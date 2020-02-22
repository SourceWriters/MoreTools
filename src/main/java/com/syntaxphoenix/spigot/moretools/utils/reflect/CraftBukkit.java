package com.syntaxphoenix.spigot.moretools.utils.reflect;

import java.util.HashMap;
import java.util.Optional;

import com.google.common.base.Predicate;
import com.syntaxphoenix.spigotlib.utils.CbReflect;

public class CraftBukkit {
	
	private HashMap<String, CbReflect> cache = new HashMap<>();
	
	public Optional<CbReflect> tryFilter(Predicate<CbReflect> filter){
		return cache.values().stream().filter(filter).findFirst();
	}
	
	public CbReflect get(String name) {
		return cache.get(name);
	}
	
	public boolean has(String name) {
		return cache.containsKey(name);
	}
	
	public CbReflect create(String name, String path) {
		if(has(name)) {
			return get(name);
		}
		CbReflect reflect = new CbReflect(path);
		cache.put(name, reflect);
		return reflect;
	}

}
