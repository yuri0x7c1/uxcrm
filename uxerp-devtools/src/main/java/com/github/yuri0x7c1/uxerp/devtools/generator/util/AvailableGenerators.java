package com.github.yuri0x7c1.uxerp.devtools.generator.util;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AvailableGenerators {

	@NoArgsConstructor
	public static class AvailableGenerator {
		@Getter
		@Setter
		String name;

		@Getter
		@Setter
		boolean enabled = true;

		public AvailableGenerator(String name) {
			super();
			this.name = name;
		}
	}

	@Getter
	@Setter
	List<AvailableGenerator> generators = new ArrayList<>();

	public void add(AvailableGenerator generator) {
		generators.add(generator);
	}
}