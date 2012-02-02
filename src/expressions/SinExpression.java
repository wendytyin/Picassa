package expressions;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.ParserException;
import model.RGBColor;
import model.util.ColorCombinations;

public class SinExpression extends ParenExpression {
    
	private static final String myCommand="sin";
    private static final String commandMatching="sin";
    private static final Pattern COMMAND_REGEX = Pattern.compile(commandMatching);

	// for the factory to look at
	private SinExpression() {}

	@Override
	public Expression getNewExpression() {
		return new SinExpression();
	}
	
	public static ExpressionFactory getFactory() {
		return new ExpressionFactory(new SinExpression());
	}

	@Override
	public RGBColor evaluate() {

		List<Expression>mySubExpressions=getSubExpressions();
		if (mySubExpressions.isEmpty()){
			throw new ParserException(
					"Not enough numbers, what are you trying to do with "
							+ myCommand +"?");
		}
		RGBColor firstOne=mySubExpressions.get(0).evaluate();
		return ColorCombinations.sin(firstOne);
	}

	@Override
	String getMyCommand() {return myCommand;
	}

    @Override
    boolean commandIsThisExpression(String commandName) {
        Matcher expMatcher = COMMAND_REGEX.matcher(commandName);
        return expMatcher.lookingAt();
    }

}
