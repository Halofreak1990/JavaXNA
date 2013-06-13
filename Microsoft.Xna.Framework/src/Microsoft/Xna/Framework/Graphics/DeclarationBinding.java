package Microsoft.Xna.Framework.Graphics;

import java.util.*;

import System.Collections.Generic.*;

class DeclarationBinding
{
	VertexElement[] elements;
	HashMap<BindingNode, Boolean> indirectOffspring;
	int referenceCount;
	BindingNode root;
	
	DeclarationBinding(VertexElement[] elements)
	{
		this.elements = elements;
		this.referenceCount = 1;
		this.root = new BindingNode();
		this.indirectOffspring = new HashMap<BindingNode, Boolean>();
	}
	
	class BindingNode
	{
		private ArrayList<KeyValuePair<DeclarationBinding, DeclarationBinding.BindingNode> > children;
		
		void AddChild(DeclarationBinding key, DeclarationBinding.BindingNode value)
		{
			if (this.children == null)
			{
				this.children = new ArrayList<KeyValuePair<DeclarationBinding, DeclarationBinding.BindingNode> >();
			}
			KeyValuePair<DeclarationBinding, DeclarationBinding.BindingNode> item  = new KeyValuePair<DeclarationBinding, DeclarationBinding.BindingNode>(key, value);
			this.children.add(item);
		}
		
		DeclarationBinding.BindingNode GetChild(DeclarationBinding key)
		{
			ArrayList<KeyValuePair<DeclarationBinding, DeclarationBinding.BindingNode> > children = this.children;
			if (children != null)
			{
				int num = 0;
				if (0 < children.size())
				{
					do
					{
						KeyValuePair<DeclarationBinding, DeclarationBinding.BindingNode> pair = children.get(num);
						if (pair.getKey() == key)
						{
							return pair.getValue();
						}
						num++;
					}
					while(num < this.children.size());
				}
			}
			return null;
		}
		
		void RecursiveRelease()
		{
			// TODO: implement this
		}
		
		void RemoveChild()
		{
			// TODO: implement this
		}
	}
}
