package com.jacky.annocation.configuration.bean;

public class TextEditor {
	private SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker) {
		super();
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
	}
	
	public void spellCheck() {
		this.spellChecker.checkSpelling();
	}
	
	
}
