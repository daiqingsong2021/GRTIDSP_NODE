package com.grtidsp.node.parent.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class KEY {
	private String m_strSrc;
	private int m_nEncryptMethod;
	private MessageDigest m_md;
	private String m_strKey;
	private byte[] m_byteDig;

	public KEY() {
	}

	public String getSrc() {
		return m_strSrc;
	}

	public void setSrc(String strSrc) {
		m_strSrc = strSrc;
	}

	public int getEncryptMethod() {
		return m_nEncryptMethod;
	}

	public void setEncryptMethod(int nEncryptMethod) {
		m_nEncryptMethod = nEncryptMethod;
	}

	public String getKey() {
		return m_strKey;
	}

	public void setKey(String strKey) {
		m_strKey = strKey;
	}

	public String Byte2Hex(byte[] b) {
		String hs = "";
		String strtmp = "";
		for (int n = 0; n < b.length; n++) {
			strtmp = (Integer.toHexString(b[n] & 0xFF));
			if (strtmp.length() == 1)
				hs = hs + "0" + strtmp;
			else
				hs = hs + strtmp;
		}
		return hs.toUpperCase();
	}

	public String toHex() {
		return Byte2Hex(getByteDig());
	}

	public byte[] getByteDig() {
		return m_byteDig;
	}

	public void setByteDig(byte[] b) {
		m_byteDig = b;
	}

	public long genKEY() throws UnsupportedEncodingException {
		int nEncryptMethod = getEncryptMethod();
		switch (nEncryptMethod) {
		case 1: {
			try {
				m_md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				return 0;
			}
			break;
		}
		case 2: {
			try {
				m_md = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException e) {
				return 0;
			}
			break;
		}
		}

		m_md.update(getSrc().getBytes("UTF-8"));
		setByteDig(m_md.digest());
		byte[] b = getByteDig();
		setKey(Arrays.toString(b));
		return 1;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		String sSSNumber = "10971736", sPage = "1", sKey = "catalog";
		KEY key = new KEY();
		// String ssConf = readSSConfig("c:");
		// System.out.print("\r\n skey="+sSSNumber+sPage+sKey+ssConf);
		String str = new String(sSSNumber + sPage + sKey + "ssConf");
		// System.out.print("\r\n "+str);
		key.setSrc(str);
		key.setEncryptMethod(1);// 1:MD5 2:SHA-1
		key.genKEY();
		// return key.toHex();
		System.out.println(key.toHex());
	}
}
