package com.syntaxphoenix.spigot.moretools.data;

import java.io.File;
import java.io.IOException;

import com.syntaxphoenix.syntaxapi.nbt.NbtCompound;
import com.syntaxphoenix.syntaxapi.nbt.NbtNamedTag;
import com.syntaxphoenix.syntaxapi.nbt.NbtTag;
import com.syntaxphoenix.syntaxapi.nbt.tools.NbtDeserializer;
import com.syntaxphoenix.syntaxapi.nbt.tools.NbtSerializer;

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

	public NbtCompound getData() {
		return data != null ? data : (data = preload());
	}

	public void set(String path, NbtTag input) {
		getData().set(path, input);
	}

	public void setInt(String path, int input) {
		getData().set(path, input);
	}

	public void setString(String path, String input) {
		getData().set(path, input);
	}

	public void setBoolean(String path, boolean input) {
		getData().set(path, input);
	}

	public NbtTag get(String path) {
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
				return (NbtCompound) NbtDeserializer.COMPRESSED.fromFile(file).getTag();
			} catch (IOException | ClassCastException e) {
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
		directory();
		try {
			if (file.exists()) {
				if (file.isDirectory()) {
					file.delete();
					file.createNewFile();
				}
			} else {
				file.createNewFile();
			}
			NbtSerializer.COMPRESSED.toFile(new NbtNamedTag("storage", data), file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
