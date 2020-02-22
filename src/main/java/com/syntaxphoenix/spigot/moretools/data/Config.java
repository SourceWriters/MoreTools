package com.syntaxphoenix.spigot.moretools.data;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	private File file;
	private YamlConfiguration config;
	
	public Config(File file) {
		this.file = file;
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public void set(String path, Object input) {
		config.set(path, input);
	}
	
	public boolean contains(String path) {
		return config.contains(path);
	}
	
	public Object get(String path) {
		return config.get(path);
	}
	
	@SuppressWarnings("unchecked")
	public <E> E get(String path, Class<E> type) {
		if(contains(path)) {
			return (E) get(path);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <E> E get(String path, E type) {
		if(contains(path)) {
			return (E) get(path);
		}
		return null;
	}
	
	public <E> E check(String path, E input) {
		if(contains(path)) {
			return get(path, input);
		}
		set(path, input);
		return input;
	}
	
	public ConfigurationSection getSection(String name) {
		if(contains(name)) {
			if(config.isConfigurationSection(name)) {
				return config.getConfigurationSection(name);
			}
			return null;
		}
		return config.createSection(name);
	}

	/*
	 * 
	 * 
	 * 
	 */

	public void directory() {
		if (file.getParent() != null) {
			File folder = file.getParentFile();
			if (folder.exists()) {
				if (!folder.isDirectory()) {
					folder.delete();
					folder.mkdirs();
				}
			} else {
				folder.mkdirs();
			}
		}
	}

	public boolean hasDirectory() {
		return file.getParent() != null;
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public void load() {
		if(file.exists()) {
			config = YamlConfiguration.loadConfiguration(file);
		} else {
			config = new YamlConfiguration();
		}
	}
	
	public void save() {
		try {
			directory();
			if(file.exists()) {
				if(file.isDirectory()) {
					file.delete();
					file.createNewFile();
				}
			} else {
				file.createNewFile();
			}
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
