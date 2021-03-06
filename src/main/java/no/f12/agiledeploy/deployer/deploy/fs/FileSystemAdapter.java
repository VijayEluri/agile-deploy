package no.f12.agiledeploy.deployer.deploy.fs;

import java.io.File;
import java.io.FileFilter;

public interface FileSystemAdapter {

	public void copyFile(File source, File target);

	public void deleteDir(File deployDirectory) throws IllegalStateException;

	public void deleteDir(File deployDirectory, FileFilter filter);

	public void moveOneUp(File file);

	public void createSymbolicLink(File source, File symLink);

	public void changePermissionsOnFile(File file, String permission);
	


}
