package com.intel.vmf;

public class FieldValue extends Variant
{
	static
    {
        System.loadLibrary ("vmf");
    }
	
	private String m_name;
	
	protected final long nativeObj;
	
	public FieldValue ()
	{
		nativeObj = n_FieldValue ();
	}
	
	public FieldValue ( final FieldValue other )
	{
		nativeObj = n_FieldValue ( other.nativeObj );
	}
	
	public FieldValue ( final String name, Variant variant )
	{
		m_name = name;
		nativeObj = n_FieldValue ( name, variant );
	}
	
	public String getName ()
	{
		//return m_name;
		return n_getName ( nativeObj ); 
	}
	
	public boolean isEqual ( final FieldValue other)
	{
		return n_isEqual (nativeObj, other.nativeObj);
	}
	
	public void Equal ( final FieldValue other)
	{
		n_equal( nativeObj, other.nativeObj );
		return;
	}
	
	@Override
	protected void finalize () throws Throwable 
	{
	    n_delete ( nativeObj );
	    super.finalize();
	}
	
	private static native long n_FieldValue ();
	private static native long n_FieldValue ( long other );
	private static native long n_FieldValue ( String name, long variant );
	private static native String n_getName ( long nativeObj ); 
	private static native boolean n_isEqual ( nativeObj, other.nativeObj );
	private static native void n_Equal ( nativeObj, other.nativeObj );
	private static native void n_delete ( long nativeObj );	
}
