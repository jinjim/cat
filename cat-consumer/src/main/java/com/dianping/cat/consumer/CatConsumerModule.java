package com.dianping.cat.consumer;

import com.dianping.cat.CatCoreModule;
import com.dianping.cat.message.io.TcpSocketReceiver;
import com.site.initialization.AbstractModule;
import com.site.initialization.Module;
import com.site.initialization.ModuleContext;

public class CatConsumerModule extends AbstractModule {
	public static final String ID = "cat-consumer";

	@Override
	public Module[] getDependencies(ModuleContext ctx) {
		return ctx.getModules(CatCoreModule.ID);
	}

	@Override
	protected void execute(ModuleContext ctx) {
		TcpSocketReceiver receiver = ctx.lookup(TcpSocketReceiver.class);

		receiver.startEncoderThreads(3);
	}
}
