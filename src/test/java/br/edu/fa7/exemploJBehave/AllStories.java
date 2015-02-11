package br.edu.fa7.exemploJBehave;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;
import java.util.Locale;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import br.edu.fa7.exemploJBehave.steps.StepDef;
import static org.jbehave.core.reporters.Format.CONSOLE;

public class AllStories extends JUnitStories{

	@Override
	public Configuration configuration() {

		Keywords keywords=new LocalizedKeywords(locale());
		
		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass()))
				//.useKeywords(keywords)
				.useStoryReporterBuilder(new StoryReporterBuilder()
				.withDefaultFormats()
				.withFormats(CONSOLE));
	}
	
	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
	}
	
	@Override
	public InjectableStepsFactory stepsFactory() {
		 return new InstanceStepsFactory(configuration(), new StepDef());
		
	}
	
	private Locale locale() {
		return new Locale("pt");
	}

}
