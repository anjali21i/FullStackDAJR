package com.core.fullstack.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.passay.PasswordData;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.RuleResultDetail;

public class IllegalRegexRule implements Rule {
	   public static final String ERROR_CODE = "ILLEGAL_MATCH";
	   protected final Pattern pattern;

	   public IllegalRegexRule(String regex) {
	      this.pattern = Pattern.compile(regex);
	   }

	   public RuleResult validate(PasswordData passwordData) {
	      RuleResult result = new RuleResult(true);
	      Matcher m = this.pattern.matcher(passwordData.getPassword());
	      if (!m.find()) {
	         result.setValid(false);
	         result.getDetails().add(new RuleResultDetail("ILLEGAL_MATCH", this.createRuleResultDetailParameters("!@#$%^&*_")));
	      }

	      return result;
	   }

	   protected Map<String, Object> createRuleResultDetailParameters(String match) {
	      Map<String, Object> m = new LinkedHashMap<String, Object>();
	      m.put("match", match);
	      m.put("pattern", this.pattern);
	      return m;
	   }

	   public String toString() {
	      return String.format("%s@%h::pattern=%s", this.getClass().getName(), this.hashCode(), this.pattern);
	   }
	}