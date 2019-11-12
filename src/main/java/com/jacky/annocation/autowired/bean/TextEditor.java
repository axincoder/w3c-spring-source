package com.jacky.annocation.autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author jacky
 * 构造方法中使用@Autowried注释。XML文件中就不需要使用constructor-arg方式再配置
 *
 */
public class TextEditor {

	private SpellChecker spellChecker;

	@Autowired
	public TextEditor(SpellChecker spellChecker) {
		super();
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
	}
	
	public void spellCheck() {
		this.spellChecker.checkSpelling();
	}

}
