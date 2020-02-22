package com.syntaxphoenix.spigot.moretools.utils.reflect;

import java.util.HashMap;
import java.util.Optional;

import com.google.common.base.Predicate;
import com.syntaxphoenix.spigotlib.utils.NmsReflect;

public class Minecraft {
	
	private HashMap<String, NmsReflect> cache = new HashMap<>();
	
	public Optional<NmsReflect> tryFilter(Predicate<NmsReflect> filter){
		return cache.values().stream().filter(filter).findFirst();
	}
	
	public NmsReflect get(String name) {
		return cache.get(name);
	}
	
	public boolean has(String name) {
		return cache.containsKey(name);
	}
	
	public NmsReflect create(String name, String path) {
		if(has(name)) {
			return get(name);
		}
		NmsReflect reflect = new NmsReflect(path);
		cache.put(name, reflect);
		return reflect;
	}

}
