package com.examples.ui.tests;

import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class SampleMenuTest extends AbstractTest {

	@Test
	public void testSampleMenu() {
		bot.menu("Sample Menu").menu("Sample Command").click();
		assertDialog();
	}

	@Test
	public void testToolbar() {
		bot.toolbarButtonWithTooltip("Say hello world (Ctrl+6)").click();
		assertDialog();
	}

	@Test
	public void testShortcut() throws ParseException {
		bot.activeShell().pressShortcut(
		        Keystrokes.MOD1, KeyStroke.getInstance("6"));
		assertDialog();
	}

	private void assertDialog() {
		SWTBotShell dialog = bot.shell("Example Menu");
		dialog.activate();
		bot.label("Hello, Eclipse world");
		bot.button("OK").click();
		bot.waitUntil(shellCloses(dialog));
	}
}
