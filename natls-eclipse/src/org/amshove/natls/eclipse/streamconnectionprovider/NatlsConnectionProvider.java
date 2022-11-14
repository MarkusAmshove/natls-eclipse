package org.amshove.natls.eclipse.streamconnectionprovider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.lsp4e.server.StreamConnectionProvider;

public class NatlsConnectionProvider implements StreamConnectionProvider {

	private Process process;

	@Override
	public InputStream getErrorStream() {
		return process.getErrorStream();
	}

	@Override
	public InputStream getInputStream() {
		return process.getInputStream();
	}

	@Override
	public OutputStream getOutputStream() {
		return process.getOutputStream();
	}

	@Override
	public void start() throws IOException {
		var builder = new ProcessBuilder("/usr/bin/java", "-jar",
				"/home/markus/dev/natls/libs/natls/build/libs/natls.jar");
		builder.directory(new File("/home/markus/dev/Entw"));
		process = builder.start();
	}

	@Override
	public void stop() {
		process.destroy();
	}

}
