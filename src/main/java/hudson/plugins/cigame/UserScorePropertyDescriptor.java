package hudson.plugins.cigame;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

import hudson.Util;
import hudson.model.Hudson;
import hudson.model.User;
import hudson.model.UserProperty;
import hudson.model.UserPropertyDescriptor;
import hudson.model.Descriptor.FormException;

/**
 * Descriptor for the {@link UserScoreProperty}.
 * 
 * @author Erik Ramfelt
 */
public class UserScorePropertyDescriptor extends UserPropertyDescriptor {

	public static final UserScorePropertyDescriptor INSTANCE = new UserScorePropertyDescriptor();
	
	public UserScorePropertyDescriptor() {
		super(UserScoreProperty.class);
	}
	
	@Override
	public String getDisplayName() {
		return null;
	}

	@Override
	public UserProperty newInstance(StaplerRequest req) throws FormException {
		String scoreStr = Util.fixEmpty(req.getParameter("game.score"));
		if (scoreStr != null) {
			return new UserScoreProperty(Double.parseDouble(scoreStr));
		} else {
			return new UserScoreProperty();
		}
	}
/*
	@Override
	public UserProperty newInstance(StaplerRequest req, JSONObject formData)
			throws FormException {
		if (formData != null) {
		return new UserScoreProperty(formData.getDouble("game.score"));
		} 
		return null;
	}
*/
	@Override
	public UserProperty newInstance(User arg0) {
		return null;
	}
}