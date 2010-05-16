package com.cadrlife.cssmath;


public enum Operator implements TwoArg {
	MULTIPLY {

		@Override
		public Double apply(Double a, Double b) {
			return a * b;
		}

		@Override
		public Long apply(Long a, Long b) {
			return a * b;
		}

	},
	DIVIDE {

		@Override
		public Double apply(Double a, Double b) {
			return a / b;
		}

		@Override
		public Long apply(Long a, Long b) {
			return a / b;
		}

		
	},
	ADD {

		@Override
		public Double apply(Double a, Double b) {
			return a + b;
		}

		@Override
		public Long apply(Long a, Long b) {
			return a + b;
		}

	},
	SUBTRACT {

		@Override
		public Double apply(Double a, Double b) {
			return a - b;
		}

		@Override
		public Long apply(Long a, Long b) {
			return a - b;
		}

	},
	MOD {

		@Override
		public Double apply(Double a, Double b) {
			return a % b;
		}

		@Override
		public Long apply(Long a, Long b) {
			return a % b;
		}

	}
	
	
}
