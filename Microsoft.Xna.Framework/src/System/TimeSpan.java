package System;

import java.util.Locale;

/**
 * Represents a time interval.
 * 
 * @author Halofreak1990
 */
public class TimeSpan implements Comparable<TimeSpan>, IEquatable<TimeSpan>
{
	/**
	 * Represents the number of ticks in 1 millisecond. This field is constant.
	 */
	public static final long TicksPerMillisecond = 0x2710L;
	private static final double MillisecondsPerTick = 0.0001;
	/**
	 * Represents the number of ticks in 1 second.
	 */
	public static final long TicksPerSecond = 0x989680L;
	private static final double SecondsPerTick = 1E-07;
	/**
	 * Represents the number of ticks in 1 minute. This field is constant.
	 */
	public static final long TicksPerMinute = 0x23c34600L;
	private static final double MinutesPerTick = 1.6666666666666667E-09;
	/**
	 * Represents the number of ticks in 1 hour. This field is constant.
	 */
	public static final long TicksPerHour = 0x861c46800L;
	private static final double HoursPerTick = 2.7777777777777777E-11;
	/**
	 * Represents the number of ticks in 1 day. This field is constant.
	 */
	public static final long TicksPerDay = 0xc92a69c000L;
	private static final double DaysPerTick = 1.1574074074074074E-12;
	private static final int MillisPerSecond = 0x3e8;
	private static final int MillisPerMinute = 0xea60;
	private static final int MillisPerHour = 0x36ee80;
	private static final int MillisPerDay = 0x5265c00;
	private static final long MaxSeconds = 0xd6bf94d5e5L;
	private static final long MinSeconds = -922337203685L;
	private static final long MaxMilliSeconds = 0x346dc5d638865L;
	private static final long MinMilliSeconds = -922337203685477L;
	/**
	 * Represents the zero TimeSpan value. This field is read-only.
	 */
	public static final TimeSpan Zero;
	/**
	 * Represents the maximum TimeSpan value. This field is read-only.
	 */
	public static final TimeSpan MaxValue;
	/**
	 * Represents the minimum TimeSpan value. This field is read-only.
	 */
	public static final TimeSpan MinValue;
	long _ticks;
	
	/**
	 * Gets the number of whole days represented by the current TimeSpan structure.
	 * 
	 * @return
	 * The day component of this instance. The return value can be positive or negative.
	 */
	public int getDays()
	{
		return (int) (this._ticks / TicksPerDay);
	}
	
	/**
	 * Gets the number of whole hours represented by the current TimeSpan structure.
	 * 
	 * @return
	 * The hour component of the current TimeSpan structure. The return value ranges from -23 through 23.
	 */
	public int getHours()
	{
		return (int) ((this._ticks / TicksPerHour) % 0x18L);
	}
	
	/**
	 * Gets the number of whole milliseconds represented by the current TimeSpan structure.
	 * 
	 * @return
	 * The millisecond component of the current TimeSpan structure. The return value ranges from -999 through 999.
	 */
	public int getMilliseconds()
	{
		return (int) ((this._ticks / TicksPerMillisecond) % MillisPerSecond);
	}
	
	/**
	 * Gets the number of whole minutes represented by the current TimeSpan structure.
	 * 
	 * @return
	 * The minute component of the current TimeSpan structure. The return value ranges from -59 through 59.
	 */
	public int getMinutes()
	{
		return (int) ((this._ticks / TicksPerMinute) % 60L);
	}
	
	/**
	 * Gets the number of whole seconds represented by the current TimeSpan structure.
	 * 
	 * @return
	 * The second component of the current TimeSpan structure. The return value ranges from -59 through 59.
	 */
	public int getSeconds()
	{
		return (int) ((this._ticks / TicksPerSecond) % 60L);
	}
	
	/**
	 * Gets the number of ticks that represent the value of the current TimeSpan structure.
	 * 
	 * @return
	 * The number of ticks contained in this instance.
	 */
	public long getTicks()
	{
		return this._ticks;
	}
	
	/**
	 * Gets the value of the current TimeSpan structure expressed in whole and fractional days.
	 * 
	 * @return
	 * The total number of days represented by this instance.
	 */
	public double getTotalDays()
	{
		return (this._ticks * DaysPerTick);
	}
	
	/**
	 * Gets the value of the current TimeSpan structure expressed in whole and fractional hours.
	 * 
	 * @return
	 * The total number of hours represented by this instance.
	 */
	public double getTotalHours()
	{
		return (this._ticks * HoursPerTick);
	}
	
	/**
	 * Gets the value of the current TimeSpan structure expressed in whole and fractional milliseconds.
	 * 
	 * @return
	 * The total number of milliseconds represented by this instance.
	 */
	public double getTotalMilliseconds()
	{
		double num = this._ticks * MillisecondsPerTick;
	    if (num > MaxMilliSeconds)
	    {
	        return MaxMilliSeconds;
	    }
	    if (num < MinMilliSeconds)
	    {
	        return MinMilliSeconds;
	    }
	    return num;
	}
	
	/**
	 * Gets the value of the current TimeSpan structure expressed in whole and fractional minutes.
	 * 
	 * @return
	 * The total number of minutes represented by this instance.
	 */
	public double getTotalMinutes()
	{
		return (this._ticks * MinutesPerTick);
	}
	
	/**
	 * Gets the value of the current TimeSpan structure expressed in whole and fractional seconds.
	 * 
	 * @return
	 * The total number of seconds represented by this instance.
	 */
	public double getTotalSeconds()
	{
		return (this._ticks * SecondsPerTick);
	}
	
	/**
	 * Initializes a new TimeSpan to the specified number of ticks.
	 * 
	 * @param ticks
	 * A time period expressed in 100-nanosecond units.
	 */
	public TimeSpan(long ticks)
	{
	    this._ticks = ticks;
	}
	
	/**
	 * Initializes a new TimeSpan to a specified number of hours, minutes, and seconds.
	 * 
	 * @param hours
	 * Number of hours.
	 * 
	 * @param minutes
	 * Number of minutes.
	 * 
	 * @param seconds
	 * Number of seconds.
	 * 
	 * @throws
	 * ArgumentOutOfRangeException
	 * The parameters specify a TimeSpan value less than MinValue or greater than MaxValue.
	 */
	public TimeSpan(int hours, int minutes, int seconds)
	{
	    this._ticks = TimeToTicks(hours, minutes, seconds);
	}
	
	/**
	 * Initializes a new TimeSpan to a specified number of days, hours, minutes, and seconds.
	 * 
	 * @param days
	 * Number of days.
	 * 
	 * @param hours
	 * Number of hours.
	 * 
	 * @param minutes
	 * Number of minutes.
	 * 
	 * @param seconds
	 * Number of seconds.
	 * 
	 * @throws
	 * ArgumentOutOfRangeException
	 * The parameters specify a TimeSpan value less than MinValue or greater than MaxValue.
	 */
	public TimeSpan(int days, int hours, int minutes, int seconds)
	{
		this(days, hours, minutes, seconds, 0);
	}
	
	/**
	 * Initializes a new TimeSpan to a specified number of days, hours, minutes, seconds, and milliseconds.
	 * 
	 * @param days
	 * Number of days.
	 * 
	 * @param hours
	 * Number of hours.
	 * 
	 * @param minutes
	 * Number of minutes.
	 * 
	 * @param seconds
	 * Number of seconds.
	 * 
	 * @param milliseconds
	 * Number of milliseconds.
	 * 
	 * @throws
	 * ArgumentOutOfRangeException
	 * The parameters specify a TimeSpan value less than MinValue or greater than MaxValue.
	 */
	public TimeSpan(int days, int hours, int minutes, int seconds, int milliseconds)
	{
	    long num = ((((((days * 0xe10L) * 0x18L) + (hours * 0xe10L)) + (minutes * 60L)) + seconds) * MillisPerSecond) + milliseconds;
	    if ((num > MaxMilliSeconds) || (num < -MinMilliSeconds))
	    {
	        throw new ArgumentOutOfRangeException(null, "TimeSpan overflowed because the duration is too long.");
	    }
	    this._ticks = num * TicksPerMillisecond;
	}
	
	/**
	 * Adds the specified TimeSpan to this instance.
	 * 
	 * @param ts
	 * A TimeSpan.
	 * 
	 * @return
	 * A TimeSpan that represents the value of this instance plus the value of ts.
	 * 
	 * @throws
	 * OverflowException
	 * The resulting TimeSpan is less than MinValue or greater than MaxValue.
	 */
	public TimeSpan Add(TimeSpan ts)
	{
	    long ticks = this._ticks + ts._ticks;
	    if (((this._ticks >> 0x3f) == (ts._ticks >> 0x3f)) && ((this._ticks >> 0x3f) != (ticks >> 0x3f)))
	    {
	        throw new OverflowException("TimeSpan overflowed because the duration is too long.");
	    }
	    return new TimeSpan(ticks);
	}
	
	/**
	 * Compares two TimeSpan values and returns an integer that indicates their relationship.
	 * 
	 * @param t1
	 * A TimeSpan.
	 * 
	 * @param t2
	 * A TimeSpan.
	 * 
	 * @return
	 * Value Condition -1 t1 is less than t20 t1 is equal to t21 t1 is greater than t2
	 */
	public static int Compare(TimeSpan t1, TimeSpan t2)
	{
	    if (t1._ticks > t2._ticks)
	    {
	        return 1;
	    }
	    if (t1._ticks < t2._ticks)
	    {
	        return -1;
	    }
	    return 0;
	}

	/**
	 * Compares this instance to a specified object and returns an indication of their relative values.
	 * 
	 * @param value
	 * An object to compare, or null.
	 * 
	 * @return
	 * Value Condition -1 The value of this instance is less than the value of value. 0 The value of this instance is equal to the value of value. 1 The value of this instance is greater than the value of value.-or- value is null.
	 * 
	 * @throws
	 * ArgumentException
	 * value is not a TimeSpan.
	 *
	public int CompareTo(Object value)
	{
	    if (value == null)
	    {
	        return 1;
	    }
	    if (!(value.getClass() == TimeSpan.class))
	    {
	        throw new ArgumentException("Object must be of type TimeSpan.");
	    }
	    long num = ((TimeSpan) value)._ticks;
	    if (this._ticks > num)
	    {
	        return 1;
	    }
	    if (this._ticks < num)
	    {
	        return -1;
	    }
	    return 0;
	}*/

	/**
	 * Compares this instance to a specified TimeSpan object and returns an indication of their relative values.
	 * 
	 * @param value
	 * A TimeSpan object to compare to this instance.
	 * 
	 * @return
	 * A signed number indicating the relative values of this instance and value.Value Description A negative integer This instance is less than value. Zero This instance is equal to value. A positive integer This instance is greater than value.
	 */
	public int compareTo(TimeSpan value)
	{
	    if (this._ticks > value._ticks)
	    {
	        return 1;
	    }
	    if (this._ticks < value._ticks)
	    {
	        return -1;
	    }
	    return 0;
	}
	
	/**
	 * Returns a new TimeSpan object whose value is the absolute value of the current TimeSpan object.
	 * 
	 * @return
	 * A new TimeSpan whose value is the absolute value of the current TimeSpan object.
	 * 
	 * @throws
	 * OverflowException
	 * The value of this instance is MinValue.
	 */
	public TimeSpan Duration()
	{
	    if (this._ticks == MinValue._ticks)
	    {
	        throw new OverflowException("The duration cannot be returned for TimeSpan.MinValue because the absolute value of TimeSpan.MinValue exceeds the value of TimeSpan.MaxValue.");
	    }
	    return new TimeSpan((this._ticks >= 0L) ? this._ticks : -this._ticks);
	}
	
	/**
	 * Returns a value indicating whether this instance is equal to a specified object.
	 * 
	 * @param value
	 * An object to compare with this instance.
	 * 
	 * @return
	 * true if value is a TimeSpan object that represents the same time interval as the current TimeSpan structure; otherwise, false.
	 */
	@Override
	public boolean equals(Object value)
	{
	    if ((value != null) && (value instanceof TimeSpan))
	    	return this.Equals((TimeSpan)value);
	    return false;
	}
	
	/**
	 * Returns a value indicating whether this instance is equal to a specified TimeSpan object.
	 * 
	 * @param obj
	 * An TimeSpan object to compare with this instance.
	 * 
	 * @return
	 * true if obj represents the same time interval as this instance; otherwise, false.
	 */
	public boolean Equals(TimeSpan obj)
	{
	    return (this._ticks == obj._ticks);
	}
	
	/**
	 * Returns a value indicating whether two specified instances of TimeSpan are equal.
	 * 
	 * @param t1
	 * A TimeSpan.
	 * 
	 * @param t2
	 * A TimeSpan.
	 * 
	 * @return
	 * true if the values of t1 and t2 are equal; otherwise, false.
	 */
	public static boolean Equals(TimeSpan t1, TimeSpan t2)
	{
	    return (t1._ticks == t2._ticks);
	}
	
	/**
	 * Returns a TimeSpan that represents a specified number of days, where the specification is accurate to the nearest millisecond.
	 * 
	 * @param value
	 * A number of days, accurate to the nearest millisecond.
	 * 
	 * @return
	 * A TimeSpan that represents value.
	 * 
	 * @throws
	 * ArgumentException
	 * value is equal to NaN.
	 * 
	 * @throws
	 * OverflowException
	 * value is less than MinValue or greater than MaxValue.
	 */
	public static TimeSpan FromDays(double value)
	{
	    return Interval(value, MillisPerDay);
	}
	
	/**
	 * Returns a TimeSpan that represents a specified number of hours, where the specification is accurate to the nearest millisecond.
	 * 
	 * @param value
	 * A number of hours accurate to the nearest millisecond.
	 * 
	 * @return
	 * A TimeSpan that represents value.
	 * 
	 * @throws
	 * ArgumentException
	 * value is equal to NaN.
	 * 
	 * @throws
	 * OverflowException
	 * value is less than MinValue or greater than MaxValue.
	 */
	public static TimeSpan FromHours(double value)
	{
	    return Interval(value, MillisPerHour);
	}
	
	/**
	 * Returns a TimeSpan that represents a specified number of milliseconds.
	 * 
	 * @param value
	 * A number of milliseconds.
	 * 
	 * @return
	 * A TimeSpan that represents value.
	 * 
	 * @throws
	 * ArgumentException
	 * value is equal to NaN.
	 * 
	 * @throws
	 * OverflowException
	 * value is less than MinValue or greater than MaxValue.
	 */
	public static TimeSpan FromMilliseconds(double value)
	{
	    return Interval(value, 1);
	}
	
	/**
	 * Returns a TimeSpan that represents a specified number of minutes, where the specification is accurate to the nearest millisecond.
	 * 
	 * @param value
	 * A number of minutes, accurate to the nearest millisecond.
	 * 
	 * @return
	 * A TimeSpan that represents value.
	 * 
	 * @throws
	 * ArgumentException
	 * value is equal to NaN.
	 * 
	 * @throws
	 * OverflowException
	 * value is less than MinValue or greater than MaxValue.
	 */
	public static TimeSpan FromMinutes(double value)
	{
	    return Interval(value, MillisPerMinute);
	}
	
	/**
	 * Returns a TimeSpan that represents a specified number of seconds, where the specification is accurate to the nearest millisecond.
	 * 
	 * @param value
	 * A number of seconds, accurate to the nearest millisecond.
	 * 
	 * @return
	 * A TimeSpan that represents value.
	 * 
	 * @throws
	 * ArgumentException
	 * value is equal to NaN.
	 * 
	 * @throws
	 * OverflowException
	 * value is less than MinValue or greater than MaxValue.
	 */
	public static TimeSpan FromSeconds(double value)
	{
	    return Interval(value, MillisPerSecond);
	}
	
	/**
	 * Returns a TimeSpan that represents a specified time, where the specification is in units of ticks.
	 * 
	 * @param value
	 * A number of ticks that represent a time.
	 * 
	 * @return
	 * A TimeSpan with a value of value.
	 */
	public static TimeSpan FromTicks(long value)
	{
	    return new TimeSpan(value);
	}
	
	/**
	 * Returns a hash code for this instance.
	 * 
	 * @return
	 * A 32-bit signed integer hash code.
	 */
	@Override
	public int hashCode()
	{
		return (((int) this._ticks) ^ ((int) (this._ticks >> 0x20)));
	}
	
	private static TimeSpan Interval(double value, int scale)
	{
	    if (Double.isNaN(value))
	    {
	        throw new ArgumentException("TimeSpan does not accept floating point Not-a-Number values.");
	    }
	    double num = value * scale;
	    double num2 = num + ((value >= 0.0) ? 0.5 : -0.5);
	    if ((num2 > 922337203685477L) || (num2 < MinMilliSeconds))
	    {
	        throw new OverflowException("TimeSpan overflowed because the duration is too long.");
	    }
	    return new TimeSpan(((long) num2) * TicksPerMillisecond);
	}
	
	private String IntToString(int n, int digits)
	{
		return String.format(Locale.getDefault(), "%0" + Integer.toString(digits) + "d", n);
	}
	
	/**
	 * Returns a TimeSpan whose value is the negated value of this instance.
	 * 
	 * @return
	 * The same numeric value as this instance, but with the opposite sign.
	 * 
	 * @throws
	 * OverflowException
	 * The negated value of this instance cannot be represented by a TimeSpan; that is, the value of this instance is MinValue.
	 */
	public TimeSpan Negate()
	{
	    if (this._ticks == MinValue._ticks)
	    {
	        throw new OverflowException("Negating the minimum value of a twos complement number is invalid.");
	    }
	    return new TimeSpan(-this._ticks);
	}
	
	/**
	 * Constructs a new TimeSpan object from a time interval specified in a string.
	 * 
	 * @param s
	 * A string that specifies a time interval.
	 * 
	 * @return
	 * A TimeSpan that corresponds to s.
	 * 
	 * @throws
	 * FormatException
	 * s has an invalid format.
	 * 
	 * @throws
	 * ArgumentNullException
	 * s is null.
	 * 
	 * @throws
	 * OverflowException
	 * s represents a number less than MinValue or greater than MaxValue.-or- At least one of the days, hours, minutes, or seconds components is outside its valid range.
	 */
	public static TimeSpan Parse(String s)
	{
	    StringParser parser2 = new TimeSpan.StringParser();
	    return new TimeSpan(parser2.Parse(s));
	}
	
	/**
	 * Subtracts the specified TimeSpan from this instance.
	 * 
	 * @param ts
	 * A TimeSpan.
	 * 
	 * @return
	 * A TimeSpan whose value is the result of the value of this instance minus the value of ts.
	 * 
	 * @throws
	 * OverflowException
	 * The return value is less than MinValue or greater than MaxValue.
	 */
	public TimeSpan Subtract(TimeSpan ts)
	{
	    long ticks = this._ticks - ts._ticks;
	    if (((this._ticks >> 0x3f) != (ts._ticks >> 0x3f)) && ((this._ticks >> 0x3f) != (ticks >> 0x3f)))
	    {
	        throw new OverflowException("TimeSpan overflowed because the duration is too long.");
	    }
	    return new TimeSpan(ticks);
	}
	
	static long TimeToTicks(int hour, int minute, int second)
	{
	    long num = ((hour * 0xe10L) + (minute * 60L)) + second;
	    if ((num > MaxSeconds) || (num < MinSeconds))
	    {
	        throw new ArgumentOutOfRangeException(null, "TimeSpan overflowed because the duration is too long.");
	    }
	    return (num * TicksPerSecond);
	}
	
	/**
	 * Returns the string representation of the value of this instance.
	 * 
	 * @return
	 * A string that represents the value of this instance. The return value is of the form: [-][d.]hh:mm:ss[.ff] Items in square brackets ([ and ]) are optional, colons and periods (: and.) are literal characters; and the other items are as follows.Item Description "-" optional minus sign indicating a negative time "d" optional days "hh" hours, ranging from 0 to 23 "mm" minutes, ranging from 0 to 59 "ss" seconds, ranging from 0 to 59 "ff" optional fractional seconds, from 1 to 7 decimal digits For more information about comparing the string representation of TimeSpan and Oracle data types, see article Q324577, "System.TimeSpan Does Not Match Oracle 9i INTERVAL DAY TO SECOND Data Type," in the Microsoft Knowledge Base at http://support.microsoft.com.
	 */
	@Override
	public String toString()
	{
	    StringBuilder builder = new StringBuilder();
	    int num = (int) (this._ticks / TicksPerDay);
	    long num2 = this._ticks % TicksPerDay;
	    if (this._ticks < 0L)
	    {
	        builder.append("-");
	        num = -num;
	        num2 = -num2;
	    }
	    if (num != 0)
	    {
	        builder.append(num);
	        builder.append(".");
	    }
	    builder.append(this.IntToString((int) ((num2 / TicksPerHour) % 0x18L), 2));
	    builder.append(":");
	    builder.append(this.IntToString((int) ((num2 / TicksPerMinute) % 60L), 2));
	    builder.append(":");
	    builder.append(this.IntToString((int) ((num2 / TicksPerSecond) % 60L), 2));
	    int n = (int) (num2 % TicksPerSecond);
	    if (n != 0)
	    {
	        builder.append(".");
	        builder.append(this.IntToString(n, 7));
	    }
	    return builder.toString();
	}
	
	/**
	 * Constructs a new TimeSpan object from a time interval specified in a string. Parameters specify the time interval and the variable where the new TimeSpan object is returned.
	 * 
	 * @param s
	 * A string that specifies a time interval.
	 * 
	 * @param result
	 * When this method returns, contains an object that represents the time interval specified by s, or Zero if the conversion failed. This parameter is passed uninitialized.
	 * 
	 * @return
	 * true if s was converted successfully; otherwise, false. This operation returns false if the s parameter is null, has an invalid format,represents a time interval less than MinValue or greater than MaxValue, or has at least one days, hours, minutes, or seconds component outside its valid range.
	 */
	public static boolean TryParse(String s, TimeSpan result)
	{
	    long num = 0;
	    StringParser parser2 = new StringParser();
	    if (parser2.TryParse(s, num))
	    {
	        result = new TimeSpan(num);
	        return true;
	    }
	    result = Zero;
	    return false;
	}
	
	static
	{
		Zero = new TimeSpan(0L);
	    MaxValue = new TimeSpan(0x7fffffffffffffffL);
	    MinValue = new TimeSpan(-9223372036854775808L);
	}
	
	private static class StringParser
	{
	    private String str;
	    private char ch;
	    private int pos;
	    private int len;
	    private ParseError error;
	    void NextChar()
	    {
	        if (this.pos < this.len)
	        {
	            this.pos++;
	        }
	        this.ch = (this.pos < this.len) ? this.str.charAt(this.pos) : '\0';
	    }
	
	    char NextNonDigit()
	    {
	        for (int i = this.pos; i < this.len; i++)
	        {
	            char ch = this.str.charAt(i);
	            if ((ch < '0') || (ch > '9'))
	            {
	                return ch;
	            }
	        }
	        return '\0';
	    }
	
	    long Parse(String s)
	    {
	        long num = 0;
	        if (this.TryParse(s, num))
	        {
	            return num;
	        }
	        switch (this.error)
	        {
	            case Format:
	                throw new FormatException("Input string was not in a correct format.");
	
	            case Overflow:
	                throw new OverflowException("TimeSpan overflowed because the duration is too long.");
	
	            case OverflowHoursMinutesSeconds:
	                throw new OverflowException("The TimeSpan could not be parsed because at least one of the hours, minutes, or seconds components is outside its valid range.");
	
	            case ArgumentNull:
	                throw new ArgumentNullException("s");
	        }
	        return 0L;
	    }
	
	    boolean TryParse(String s, long value)
	    {
	        long num = 0;
	        value = 0L;
	        if (s == null)
	        {
	            this.error = ParseError.ArgumentNull;
	            return false;
	        }
	        this.str = s;
	        this.len = s.length();
	        this.pos = -1;
	        this.NextChar();
	        this.SkipBlanks();
	        boolean flag = false;
	        if (this.ch == '-')
	        {
	            flag = true;
	            this.NextChar();
	        }
	        if (this.NextNonDigit() == ':')
	        {
	            if (!this.ParseTime(num))
	            {
	                return false;
	            }
	        }
	        else
	        {
	            int num2 = 0;
	            if (!this.ParseInt(0xa2e3ff, num2))
	            {
	                return false;
	            }
	            num = num2 * 0xc92a69c000L;
	            if (this.ch == '.')
	            {
	                long num3 = 0;
	                this.NextChar();
	                if (!this.ParseTime(num3))
	                {
	                    return false;
	                }
	                num += num3;
	            }
	        }
	        if (flag)
	        {
	            num = -num;
	            if (num > 0L)
	            {
	                this.error = ParseError.Overflow;
	                return false;
	            }
	        }
	        else if (num < 0L)
	        {
	            this.error = ParseError.Overflow;
	            return false;
	        }
	        this.SkipBlanks();
	        if (this.pos < this.len)
	        {
	            this.error = ParseError.Format;
	            return false;
	        }
	        value = num;
	        return true;
	    }
	
	    boolean ParseInt(int max, int i)
	    {
	        i = 0;
	        int pos = this.pos;
	        while ((this.ch >= '0') && (this.ch <= '9'))
	        {
	            if ((((long) i) & 0xf0000000L) != 0L)
	            {
	                this.error = ParseError.Overflow;
	                return false;
	            }
	            i = ((i * 10) + this.ch) - 0x30;
	            if (i < 0)
	            {
	                this.error = ParseError.Overflow;
	                return false;
	            }
	            this.NextChar();
	        }
	        if (pos == this.pos)
	        {
	            this.error = ParseError.Format;
	            return false;
	        }
	        if (i > max)
	        {
	            this.error = ParseError.Overflow;
	            return false;
	        }
	        return true;
	    }

	    boolean ParseTime(long time)
	    {
	        int num = 0;
	        time = 0L;
	        if (!this.ParseInt(0x17, num))
	        {
	            if (this.error == ParseError.Overflow)
	            {
	                this.error = ParseError.OverflowHoursMinutesSeconds;
	            }
	            return false;
	        }
	        time = num * 0x861c46800L;
	        if (this.ch != ':')
	        {
	            this.error = ParseError.Format;
	            return false;
	        }
	        this.NextChar();
	        if (!this.ParseInt(0x3b, num))
	        {
	            if (this.error == ParseError.Overflow)
	            {
	                this.error = ParseError.OverflowHoursMinutesSeconds;
	            }
	            return false;
	        }
	        time += num * TicksPerMinute;
	        if (this.ch == ':')
	        {
	            this.NextChar();
	            if (this.ch != '.')
	            {
	                if (!this.ParseInt(0x3b, num))
	                {
	                    if (this.error == ParseError.Overflow)
	                    {
	                        this.error = ParseError.OverflowHoursMinutesSeconds;
	                    }
	                    return false;
	                }
	                time += num * TicksPerSecond;
	            }
	            if (this.ch == '.')
	            {
	                this.NextChar();
	                int num2 = 0x989680;
	                while (((num2 > 1) && (this.ch >= '0')) && (this.ch <= '9'))
	                {
	                    num2 /= 10;
	                    time += (this.ch - '0') * num2;
	                    this.NextChar();
	                }
	            }
	        }
	        return true;
	    }

	    void SkipBlanks()
	    {
	        while ((this.ch == ' ') || (this.ch == '\t'))
	        {
	            this.NextChar();
	        }
	    }
	    // Nested Types
	    private enum ParseError
	    {
	        ArgumentNull(4),
	        Format(1),
	        Overflow(2),
	        OverflowHoursMinutesSeconds(3);
	        
	        @SuppressWarnings("unused")
			private final int value;
			private ParseError(int value)
			{
				this.value = value;
			}
		}
	}
}
