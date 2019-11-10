package com.jacky.di.innerClass.bean;

public class TextEditor {
	private SpellChecker spellChecker;

	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Inside setSpellChecker.");
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return this.spellChecker;
	}

	public void spellCheck() {
		this.spellChecker.checkSpelling();
	}
}
