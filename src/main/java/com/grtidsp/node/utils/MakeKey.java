package com.grtidsp.node.utils;

/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
public class MakeKey {
	public MakeKey() {
	}

	public String getKey(String str) {
		KEY key = new KEY();
		String sReturn = "";
		try {
			key.setSrc(str);
			key.setEncryptMethod(1);// 1:MD5 2:SHA-1
			key.genKEY();
			sReturn = key.toHex();
		} catch (Exception e) {
		}
		return sReturn;
	}

	/**
	 */
	public static String getSKey(String str) {
		KEY key = new KEY();
		String sReturn = "";
		try {
			key.setSrc(str);
			key.setEncryptMethod(1);// 1:MD5 2:SHA-1
			key.genKEY();
			sReturn = key.toHex();
		} catch (Exception e) {
		}
		return sReturn;
	}

	public String getDXDetailKey(String sDXNumber) {
		KEY key = new KEY();
		String sReturn = "";
		if (sDXNumber == null)
			return sReturn;
		if (sDXNumber.trim().equals(""))
			return sReturn;
		String str = sDXNumber + "sDx5show";
		try {
			key.setSrc(str);
			key.setEncryptMethod(1);// 1:MD5 2:SHA-1
			key.genKEY();
			sReturn = key.toHex();
		} catch (Exception e) {
		}
		return sReturn;
	}

	public static void main(String[] args) {
		MakeKey m = new MakeKey();
		String sTemp = m.getKey("[155]" + "[2011-03-04]+KL0*}PIU");
		System.out.println(sTemp);
	}

}
