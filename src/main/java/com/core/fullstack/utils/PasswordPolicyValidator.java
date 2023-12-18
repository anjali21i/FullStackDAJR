package com.core.fullstack.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.passay.CharacterCharacteristicsRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.EnglishSequenceData;
import org.passay.IllegalSequenceRule;
import org.passay.LengthRule;
import org.passay.MessageResolver;
import org.passay.PasswordData;
import org.passay.PasswordGenerator;
import org.passay.PasswordValidator;
import org.passay.PropertiesMessageResolver;
import org.passay.RepeatCharacterRegexRule;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.RuleResultDetail;
import org.passay.UsernameRule;
import org.passay.WhitespaceRule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordPolicyValidator {

	List<CharacterRule> passwordGenerationRuleList;
	List<Rule> passwordValidationRuleList;
	PasswordValidator validator;
	PasswordGenerator generator;
	Properties prop;
	MessageResolver resolver;

	public PasswordPolicyValidator() {
		this.loadProperties();
		this.passwordGenerationRuleList = this.passwordGenerationRuleSet();
		this.passwordValidationRuleList = this.getPasswordValidationRuleSet();
		this.validator = new PasswordValidator(this.resolver, this.passwordValidationRuleList);
		this.generator = new PasswordGenerator();
	}

	public void loadProperties() {
		this.prop = new Properties();
		InputStream input = null;

		try {
			input = this.getClass().getResourceAsStream("/passwordconfig.properties");
			if (input == null) {
				input = this.getClass().getResourceAsStream("/nativepasswordconfig.properties");
			}

			this.prop.load(input);
			this.resolver = new PropertiesMessageResolver(this.prop);
		} catch (IOException var11) {
			var11.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException var10) {
					var10.printStackTrace();
				}
			}

		}

	}
	
	public static List<String> getA(String u, String p) {
		try {
//			return PasswordPolicyValidator.validatePassword(u,p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		getA("anj", "tty@ddd4.nj");
	}

	public List<String> validatePassword(String username, String password) {
		if (!StringUtils.isEmpty(password)) {
			RuleResult result = this.validator.validate(new PasswordData(password, username, (List) null));
			if (!result.isValid()) {
				log.info("Password [" + password + "] is Invalid");
				List<RuleResultDetail> errorListPrev = result.getDetails();
				List<RuleResultDetail> errorListNew = new ArrayList<RuleResultDetail>();
				if (errorListPrev != null && !errorListPrev.isEmpty()) {
					Iterator<RuleResultDetail> it = errorListPrev.iterator();

					while (it.hasNext()) {
						RuleResultDetail ruleResult = (RuleResultDetail) it.next();
						if (!ruleResult.getErrorCode().equalsIgnoreCase("INSUFFICIENT_UPPERCASE")
								&& !ruleResult.getErrorCode().equalsIgnoreCase("INSUFFICIENT_LOWERCASE")) {
							errorListNew.add(ruleResult);
						}
					}

					result.setDetails(errorListNew);
					Iterator<String> i$ = this.validator.getMessages(result).iterator();

					while (i$.hasNext()) {
						String msg = (String) i$.next();
						System.out.println(msg);
					}
				}

				return this.validator.getMessages(result);
			}

			log.info("Password [" + password + "] is Valid");
		}

		return null;
	}

	public List<CharacterRule> passwordGenerationRuleSet() {
		List<CharacterRule> ruleSet = new ArrayList<CharacterRule>();
		if (StringUtils.isNumeric(this.prop.getProperty("UPPERCASE_COUNT"))) {
			ruleSet.add(new CharacterRule(EnglishCharacterData.UpperCase,
					Integer.valueOf(this.prop.getProperty("UPPERCASE_COUNT"))));
		}

		if (StringUtils.isNumeric(this.prop.getProperty("LOWERCASE_COUNT"))) {
			ruleSet.add(new CharacterRule(EnglishCharacterData.LowerCase,
					Integer.valueOf(this.prop.getProperty("LOWERCASE_COUNT"))));
		}

		if (StringUtils.isNumeric(this.prop.getProperty("DIGIT_COUNT"))) {
			ruleSet.add(new CharacterRule(EnglishCharacterData.Digit,
					Integer.valueOf(this.prop.getProperty("DIGIT_COUNT"))));
		}

		if (StringUtils.isNumeric(this.prop.getProperty("SPECIAL_CHAR_COUNT"))) {
			ruleSet.add(new CharacterRule(EnglishCustomCharData.Special,
					Integer.valueOf(this.prop.getProperty("SPECIAL_CHAR_COUNT"))));
		}

		return ruleSet;
	}

	public List<Rule> getPasswordValidationRuleSet() {
		List<Rule> ruleSet = new ArrayList<Rule>();
		if (StringUtils.isNotEmpty(this.prop.getProperty("MAX_LENGTH_RANGE"))
				&& this.prop.getProperty("MAX_LENGTH_RANGE").split(",").length == 2) {
			String[] rangeArr = this.prop.getProperty("MAX_LENGTH_RANGE").split(",");
			ruleSet.add(new LengthRule(Integer.valueOf(rangeArr[0]), Integer.valueOf(rangeArr[1])));
		}

		if (StringUtils.isNotEmpty(this.prop.getProperty("WHITE_SPACE_VALIDATION_REQUIRED"))
				&& this.prop.getProperty("WHITE_SPACE_VALIDATION_REQUIRED").equalsIgnoreCase("true")) {
			ruleSet.add(new WhitespaceRule());
		}

		if (StringUtils.isNotEmpty(this.prop.getProperty("USERNAME_VALIDATION_REQUIRED"))
				&& this.prop.getProperty("USERNAME_VALIDATION_REQUIRED").equalsIgnoreCase("true")) {
			ruleSet.add(new UsernameRule());
		}

		if (StringUtils.isNumeric(this.prop.getProperty("ALPHABETICAL_ILLEGAL_SEQUENCE_COUNT"))) {
			ruleSet.add(new IllegalSequenceRule(EnglishSequenceData.Alphabetical,
					Integer.valueOf(this.prop.getProperty("ALPHABETICAL_ILLEGAL_SEQUENCE_COUNT")), false, true));
		}

		if (StringUtils.isNumeric(this.prop.getProperty("NUMERICAL_ILLEGAL_SEQUENCE_COUNT"))) {
			ruleSet.add(new IllegalSequenceRule(EnglishSequenceData.Numerical,
					Integer.valueOf(this.prop.getProperty("NUMERICAL_ILLEGAL_SEQUENCE_COUNT")), false, true));
		}

		if (StringUtils.isNumeric(this.prop.getProperty("REPEAT_CHAR_COUNT"))) {
			ruleSet.add(new RepeatCharacterRegexRule(Integer.valueOf(this.prop.getProperty("REPEAT_CHAR_COUNT"))));
		}

		if (StringUtils.isNumeric(this.prop.getProperty("DIGIT_COUNT"))) {
			ruleSet.add(new CharacterRule(EnglishCharacterData.Digit,
					Integer.valueOf(this.prop.getProperty("DIGIT_COUNT"))));
		}

		if (StringUtils.isNumeric(this.prop.getProperty("SPECIAL_CHAR_COUNT"))) {
			ruleSet.add(new CharacterRule(EnglishCustomCharData.Special,
					Integer.valueOf(this.prop.getProperty("SPECIAL_CHAR_COUNT"))));
			ruleSet.add(new IllegalRegexRule(this.prop.getProperty("PASSWORD_PATTERN")));
		}

		List<CharacterRule> anyOneRuleSet = new ArrayList<CharacterRule>();
		if (StringUtils.isNumeric(this.prop.getProperty("UPPERCASE_COUNT"))) {
			anyOneRuleSet.add(new CharacterRule(EnglishCharacterData.UpperCase,
					Integer.valueOf(this.prop.getProperty("UPPERCASE_COUNT"))));
		}

		if (StringUtils.isNumeric(this.prop.getProperty("LOWERCASE_COUNT"))) {
			anyOneRuleSet.add(new CharacterRule(EnglishCharacterData.LowerCase,
					Integer.valueOf(this.prop.getProperty("LOWERCASE_COUNT"))));
		}

		CharacterCharacteristicsRule charRules = new CharacterCharacteristicsRule();
		charRules.setNumberOfCharacteristics(1);
		charRules.setRules(anyOneRuleSet);
		ruleSet.add(charRules);
		return ruleSet;
	}

}
