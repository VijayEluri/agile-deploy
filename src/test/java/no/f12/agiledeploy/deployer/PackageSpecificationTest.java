package no.f12.agiledeploy.deployer;

import static org.junit.Assert.*;

import java.io.File;

import no.f12.agiledeploy.deployer.repo.PackageSpecification;

import org.junit.Test;

public class PackageSpecificationTest {

	@Test
	public void shouldResloveCorrectPathForArtifact() {
		PackageSpecification spec = TestDataProvider.createDefaultSpec(false);
		assertEquals("org/springframework/spring-core/2.5.6", spec.getRepositoryInformation().getArtifactPath());
	}

	@Test
	public void shouldResloveCorrectPathForArtifactIfSnapshot() {
		PackageSpecification spec = TestDataProvider.createDefaultSpec(true);
		assertEquals("org/springframework/spring-core/2.5.6-SNAPSHOT", spec.getRepositoryInformation()
				.getArtifactPath());
	}

	@Test
	public void shouldResolveCorrectNameForFile() {
		PackageSpecification spec = TestDataProvider.createDefaultSpec(false);
		assertEquals("spring-core-2.5.6", spec.getArtifactFileName());
	}

	@Test
	public void shouldResloveCorrectNameForFileWithSnapshot() {
		PackageSpecification spec = TestDataProvider.createDefaultSpec(true);
		assertEquals("spring-core-2.5.6-SNAPSHOT", spec.getArtifactFileName());
	}

	@Test
	public void shouldDetectSnapshot() {
		PackageSpecification spec = TestDataProvider.createDefaultSpec(true);
		assertTrue(spec.isSnapshot());
	}

	@Test
	public void shouldGiveCorrectArtifactPath() {
		File workingPath = new File(".");
		DeploymentSpecification ds = TestDataProvider.createDefaultDeploymentSpec(true, workingPath, null);
		assertEquals(new File(workingPath, "spring-core"), ds.getArtifactPath());
	}

	@Test
	public void shouldGiveCorrectArtifactDataDirectory() {
		File workingPath = new File(".");
		DeploymentSpecification ds = TestDataProvider.createDefaultDeploymentSpec(true, workingPath, null);
		assertEquals(new File(workingPath, "spring-core/test/data"),
				ds.getDataDirectory());
	}

	@Test
	public void shouldGiveCorrectPropertiesDirectory() {
		File workingPath = new File(".");
		DeploymentSpecification ds = TestDataProvider.createDefaultDeploymentSpec(true, workingPath, null);
		assertEquals(new File(workingPath, "spring-core/test/current/config"),
				ds.getConfigurationDirectory());
	}

	@Test
	public void shouldGiveCorrectInstallationDirectory() {
		File workingPath = new File(".");
		DeploymentSpecification ds = TestDataProvider.createDefaultDeploymentSpec(true, workingPath, null);
		assertEquals(new File(workingPath, "spring-core/test/current"),
				ds.getLastInstalledVersionDirectory());
	}

}
