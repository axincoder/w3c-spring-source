package com.jacky.annocation.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 基于Java的配置方式，配置对象依赖关系，下面是TextEditor类依赖SpellChecker类
 */
@Configuration
public class TextEditorConfig {

	@Bean
	public TextEditor textEditor() {
		return new TextEditor(spellChecker());//这里配置了依赖关系
	}
	
	@Bean
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}
}
