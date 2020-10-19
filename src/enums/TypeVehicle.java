package enums;

import java.util.HashMap;
import java.util.Map;

public enum TypeVehicle {
	Frigate(0),SpyGlider(1),Amphibious(2),Bicycle(3),GameGlider(4),Crusie(5),ElectricBicycle(6),HybridAircraft(7),Jeep(8);
    private int value;
    private static Map map = new HashMap<>();

    private TypeVehicle(int value) {
        this.value = value;
    }

    static {
        for (TypeVehicle vType : TypeVehicle.values()) {
            map.put(vType.value, vType);
        }
    }

    public static TypeVehicle valueOf(int pageType) {
        return (TypeVehicle) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
