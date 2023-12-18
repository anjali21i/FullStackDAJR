package com.core.fullstack.utils;

public enum EnglishCustomCharData implements org.passay.CharacterData {
	Special("INSUFFICIENT_SPECIAL", "_!@#$%^&*");

	private final String errorCode;
	private final String characters;

	private EnglishCustomCharData(String code, String charString) {
		this.errorCode = code;
		this.characters = charString;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public String getCharacters() {
		return this.characters;
	}
}