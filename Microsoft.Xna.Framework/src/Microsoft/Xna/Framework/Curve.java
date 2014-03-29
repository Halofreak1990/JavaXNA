package Microsoft.Xna.Framework;

import System.*;

/**
 * Stores an arbitrary collection of 2D CurveKey points, and provides methods for evaluating features of the curve they define.
 * 
 * @author Halofreak1990
 */
public class Curve
{
	private CurveKeyCollection keys;

	/**
	 * Gets a value indicating whether the curve is constant.
	 * 
	 * @return
	 * true if the curve is constant; otherwise, false.
	 */
	public boolean IsConstant()
	{
		return this.keys.Count() <= 1;
	}

	/**
	 * Gets a collection of CurveKey points that make up the curve.
	 * 
	 * @return
	 * The points that make up the curve.
	 */
	public CurveKeyCollection getKeys()
	{
		return keys;
	}

	/**
	 * Specifies how to handle weighting values that are greater than the last control point in the curve.
	 */
	public CurveLoopType PostLoop;

	/**
	 * Specifies how to handle weighting values that are less than the first control point in the curve.
	 */
	public CurveLoopType PreLoop;

	/**
	 * Initializes a new instance of the Curve class.
	 */
	public Curve()
	{
		this.keys = new CurveKeyCollection();
	}

	private float GetCurvePosition(float position)
	{
		// only for position in curve
		CurveKey prev = this.keys.get(0);
		CurveKey next;

		for (int i = 1; i < this.keys.Count(); i++)
		{
			next = this.keys.get(i);

			if (next.getPosition() >= position)
			{
				if (prev.Continuity == CurveContinuity.Step)
				{
					if (position >= 1f)
					{
						return next.Value;
					}

					return prev.Value;
				}

				float t = (position - prev.getPosition()) / (next.getPosition() - prev.getPosition());//to have t in [0,1]
				float ts = t * t;
				float tss = ts * t;
				//After a lot of search on internet I have found all about spline function
				// and bezier (phi'sss ancien) but finally use hermite curve 
				//http://en.wikipedia.org/wiki/Cubic_Hermite_spline
				//P(t) = (2*t^3 - 3t^2 + 1)*P0 + (t^3 - 2t^2 + t)m0 + (-2t^3 + 3t^2)P1 + (t^3-t^2)m1
				//with P0.value = prev.value , m0 = prev.tangentOut, P1= next.value, m1 = next.TangentIn
				return (2 * tss - 3 * ts + 1f) * prev.Value + (tss - 2 * ts + t) * prev.TangentOut + (3 * ts - 2 * tss) * next.Value + (tss - ts) * next.TangentIn;
			}

			prev = next;
		}

		return 0f;
	}

	private int GetNumberOfCycle(float position)
	{
		float cycle = (position - keys.get(0).getPosition()) / (keys.get(keys.Count() - 1).getPosition() - keys.get(0).getPosition());

		if (cycle < 0f)
		{
			cycle--;
		}

		return (int)cycle;
	}

	/**
	 * Creates a copy of this Curve.
	 * 
	 * @return
	 * A copy of this Curve.
	 */
	public Curve Clone()
	{
		Curve curve = new Curve();

		curve.keys = this.keys.Clone();
		curve.PreLoop = this.PreLoop;
		curve.PostLoop = this.PostLoop;

		return curve;
	}

	/**
	 * Computes a specified type of TangentIn and a specified type of TangentOut for a given CurveKey.
	 * 
	 * @param keyIndex
	 * The index of the CurveKey for which to compute tangents (in the Keys collection of the Curve).
	 * 
	 * @param tangentInType
	 * The type of TangentIn to compute (one of the types specified in the CurveTangent enumeration).
	 * 
	 * @param tangentOutType
	 * The type of TangentOut to compute (one of the types specified in the CurveTangent enumeration).
	 */
	public void ComputeTangent(int keyIndex, CurveTangent tangentInType, CurveTangent tangentOutType)
	{
		// See http://msdn.microsoft.com/en-us/library/microsoft.xna.framework.curvetangent.aspx

		CurveKey key = keys.get(keyIndex);

		float p0, p, p1;
		p0 = p = p1 = key.getPosition();

		float v0, v, v1;
		v0 = v = v1 = key.Value;

		if ( keyIndex > 0 )
		{
			p0 = keys.get(keyIndex - 1).getPosition();
			v0 = keys.get(keyIndex - 1).Value;
		}

		if (keyIndex < keys.Count() - 1)
		{
			p1 = keys.get(keyIndex + 1).getPosition();
			v1 = keys.get(keyIndex + 1).Value;
		}

		switch (tangentInType)
		{
		case Flat:
			key.TangentIn = 0;
			break;
		case Linear:
			key.TangentIn = v - v0;
			break;
		case Smooth:
			float pn = p1 - p0;

			if (Math.abs(pn) < Single.Epsilon)
			{
				key.TangentIn = 0;
			}
			else
			{
				key.TangentIn = (v1 - v0) * ((p - p0) / pn);
			}
			break;
		}

		switch (tangentOutType)
		{
		case Flat:
			key.TangentOut = 0;
			break;
		case Linear:
			key.TangentOut = v1 - v;
			break;
		case Smooth:
			float pn = p1 - p0;

			if (Math.abs(pn) < Single.Epsilon)
			{
				key.TangentOut = 0;
			}
			else
			{
				key.TangentOut = (v1 - v0) * ((p1 - p) / pn);
			}
			break;
		}
	}

	/**
	 * Computes both the TangentIn and the TangentOut for a CurveKey specified by its index.
	 * 
	 * @param keyIndex
	 * The index of the CurveKey for which to compute tangents (in the Keys collection of the Curve).
	 * 
	 * @param tangentType
	 * The type of tangents to compute (one of the types specified in the CurveTangent enumeration).
	 */
	public void ComputeTangent(int keyIndex, CurveTangent tangentType)
	{
		this.ComputeTangent(keyIndex, tangentType, tangentType);
	}

	/**
	 * Computes all tangents for all CurveKeys in this Curve, using different tangent types for TangentOut and TangentIn.
	 * 
	 * @param tangentInType
	 * The type of TangentIn to compute (one of the types specified in the CurveTangent enumeration).
	 * 
	 * @param tangentOutType
	 * The type of TangentOut to compute (one of the types specified in the CurveTangent enumeration).
	 */
	public void ComputeTangents(CurveTangent tangentInType, CurveTangent tangentOutType)
	{
		for (int i = 0; i < keys.Count(); i++)
		{
			ComputeTangent(i, tangentInType, tangentOutType);
		}
	}

	/**
	 * Computes all tangents for all CurveKeys in this Curve, using a specified tangent type for both TangentIn and TangentOut.
	 * 
	 * @param tangentType
	 * The type of TangentOut and TangentIn to compute (one of the types specified in the CurveTangent enumeration).
	 */
	public void ComputeTangents(CurveTangent tangentType)
	{
		this.ComputeTangents(tangentType, tangentType);
	}

	/**
	 * Finds the value at a position on the Curve.
	 * 
	 * @param position
	 * The position on the Curve.
	 * 
	 * @return
	 */
	public float Evaluate(float position)
	{
		CurveKey first = keys.get(0);
		CurveKey last = keys.get(keys.Count() - 1);

		if (position < first.getPosition())
		{
			switch (this.PreLoop)
			{
			case Constant:
				//constant
				return first.Value;

			case Linear:
				// linear y = a*x +b with a tangent of last point
				return first.Value - first.TangentIn * (first.getPosition() - position);

			case Cycle:
				//start -> end / start -> end
				int cycle = GetNumberOfCycle(position);
				float virtualPos = position - (cycle * (last.getPosition() - first.getPosition()));
				return GetCurvePosition(virtualPos);

			case CycleOffset:
				//make the curve continue (with no step) so must up the curve each cycle of delta(value)
				cycle = GetNumberOfCycle(position);
				virtualPos = position - (cycle * (last.getPosition() - first.getPosition()));
				return (GetCurvePosition(virtualPos) + cycle * (last.Value - first.Value));

			case Oscillate:
				//go back on curve from end and target start 
				// start-> end / end -> start
				cycle = GetNumberOfCycle(position);

				if (0 == cycle % 2f)//if pair
				{
					virtualPos = position - (cycle * (last.getPosition() - first.getPosition()));
				}
				else
				{
					virtualPos = last.getPosition() - position + first.getPosition() + (cycle * (last.getPosition() - first.getPosition()));
				}

				return GetCurvePosition(virtualPos);
			}
		}
		else if (position > last.getPosition())
		{
			int cycle;

			switch (this.PostLoop)
			{
			case Constant:
				//constant
				return last.Value;

			case Linear:
				// linear y = a*x +b with a tangent of last point
				return last.Value + first.TangentOut * (position - last.getPosition());

			case Cycle:
				//start -> end / start -> end
				cycle = GetNumberOfCycle(position);
				float virtualPos = position - (cycle * (last.getPosition() - first.getPosition()));
				return GetCurvePosition(virtualPos);

			case CycleOffset:
				//make the curve continue (with no step) so must up the curve each cycle of delta(value)
				cycle = GetNumberOfCycle(position);
				virtualPos = position - (cycle * (last.getPosition() - first.getPosition()));
				return (GetCurvePosition(virtualPos) + cycle * (last.Value - first.Value));

			case Oscillate:
				//go back on curve from end and target start 
				// start-> end / end -> start
				cycle = GetNumberOfCycle(position);
				virtualPos = position - (cycle * (last.getPosition() - first.getPosition()));

				if (0 == cycle % 2f)//if pair
				{
					virtualPos = position - (cycle * (last.getPosition() - first.getPosition()));
				}
				else
				{
					virtualPos = last.getPosition() - position + first.getPosition() + (cycle * (last.getPosition() - first.getPosition()));
				}

				return GetCurvePosition(virtualPos);
			}
		}

		//in curve
		return GetCurvePosition(position);
	}
}
