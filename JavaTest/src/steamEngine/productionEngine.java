package steamEngine;

public class productionEngine implements engineTool {

	public Float internalCombustionEngine(int gasoline, int dieselFuel) {

		if (gasoline + dieselFuel >= 8) {

			Float gasolineSpend = 9.00F * gasoline;
			Float dieselFuelSpend = 12.00F * dieselFuel;
			return gasolineSpend + dieselFuelSpend;
		} else

			return null;
	}

	@Override
	public Float steamEngine(int wood, int coal) {
		
		if (wood + coal >= 2) {

			Float woodSpend = 4.35F * wood;
			Float coalFuelSpend = 5.65F * coal;
			return woodSpend + coalFuelSpend;
		} else

			return null;
	}
	
	

}
