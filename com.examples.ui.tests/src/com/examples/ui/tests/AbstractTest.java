package com.examples.ui.tests;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public abstract class AbstractTest {

	public static SWTWorkbenchBot bot;

	@BeforeClass
	public static void initBot() {
		bot = new SWTWorkbenchBot();
		// Welcome view prevents for reaching the toolbar
		// so we need to close it
		closeWelcomePage();
	}

	private static void closeWelcomePage() {
		for (SWTBotView view : bot.views()) {
			if (view.getTitle().equals("Welcome")) {
				view.close();
			}
		}
	}

	@AfterClass
	public static void afterClass() {
		bot.resetWorkbench();
	}

}
