package com.syntaxphoenix.spigot.moretools.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.syntaxphoenix.spigotlib.mcnbt.NbtBase;
import com.syntaxphoenix.spigotlib.mcnbt.NbtCompound;
import com.syntaxphoenix.spigotlib.mcnbt.NbtTools;

public class DataStorage {

	private File file;
	private NbtCompound data;

	public DataStorage(File file) {
		this.file = file;
	}
	
	/*
	 * 
	 * 
	 * 
	 */
	
	public void set(Saveable save) {
		save.save(getData());
	}
	
	public NbtCompound getData() {
		return data != null ? data : (data = preload());
	}

	public void set(String path, NbtBase input) {
		getData().set(path, input);
	}

	public void setInt(String path, int input) {
		getData().setInt(path, input);
	}

	public void setString(String path, String input) {
		getData().setString(path, input);
	}

	public void setBoolean(String path, boolean input) {
		getData().setBoolean(path, input);
	}

	public NbtBase get(String path) {
		return getData().get(path);
	}

	public int getInt(String path) {
		return getData().getInt(path);
	}

	public String getString(String path) {
		return getData().getString(path);
	}

	public boolean getBoolean(String path) {
		return getData().getBoolean(path);
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

	private NbtCompound preload() {
		if (file.exists()) {
			try {
				DataInputStream input = new DataInputStream(new FileInputStream(file));
				return NbtTools.readNbt(input);
			} catch (FileNotFoundException | ReflectiveOperationException e) {
				return new NbtCompound();
			}
		} else {
			return new NbtCompound();
		}
	}
	
	/*
	 * 
	 * 
	 * 
	 */

	public void load() {
		data = preload();
	}

	public void save() {
		NbtCompound store = new NbtCompound();
		store.set("Storage", data);

		DataOutputStream output = null;
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
			output = new DataOutputStream(new FileOutputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (output != null) {
			store.write(output);
		}
	}

}
