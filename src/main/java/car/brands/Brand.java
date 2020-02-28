package car.brands;

import java.util.HashMap;
import java.util.Map;

public enum Brand {
    AC("AC"),
    ALFA_ROMEO("Alfa Romeo"),
    ARO("Aro"),
    ASTON_MARTIN("Aston Martin"),
    AUDI("Audi"),
    AUSTIN("Austin"),
    AUTOBIANCHI("Autobianchi"),
    BENTLEY("Bentley"),
    BMW("BMW"),
    BUICK("Buick"),
    CADILLAC("Cadillac"),
    CHERY("Chery"),
    CHEVROLET("Chevrolet"),
    CHRYSLER("Chrysler"),
    CITROEN("Citroen"),
    DACIA("Dacia"),
    DAEWOO("Daewoo"),
    DAIHATSU("Daihatsu"),
    DODGE("Dodge"),
    FERRARI("Ferrari"),
    FIAT("Fiat"),
    FORD("Ford"),
    GAZ("GAZ"),
    GREAT_WALL("Great Wall"),
    GMC("GMC"),
    HONDA("Honda"),
    HUMMER("Hummer"),
    HYUNDAI("Hyundai"),
    INFINITI("Infiniti"),
    INNOCENTI("Innocenti"),
    ISUZU("Isuzu"),
    JAGUAR("Jaguar"),
    JEEP("Jeep"),
    KATAY_GONOW("Katay Gonow"),
    KIA("Kia"),
    LADA("Lada"),
    LAMBORGHINI("Lamborghini"),
    LANCIA("Lancia"),
    LAND_ROVER("Land Rover"),
    LEXUS("Lexus"),
    LINCOLN("Lincoln"),
    LOTUS("Lotus"),
    MAHINDRA("Mahindra"),
    MASERATI("Maserati"),
    MAZDA("Mazda"),
    MERCEDES_BENZ("Mercedes Benz"),
    MINI("Mini"),
    MG("MG"),
    MITSUBISHI("Mitsubishi"),
    MOSZKVICS("Moszkvics"),
    NISSAN("Nissan"),
    OLDSMOBILE("Oldsmobile"),
    OPEL("Opel"),
    PEUGEOT("Peugeot"),
    PIAGGIO("Piaggio"),
    PLYMOUTH("Plymouth"),
    POLONEZ("Polonez"),
    POLSKI_FIAT("Polski Fiat"),
    PONTIAC("Pontiac"),
    PORSCHE("Porsche"),
    PROTON("Proton"),
    RENAULT("Renault"),
    ROLLS_ROYCE("Rolls Royce"),
    ROVER("Rover"),
    SAAB("Saab"),
    SEAT("Seat"),
    SHUANGHUAN("Shuanghuan"),
    SIMCA("Simca"),
    SMART("Smart"),
    SSANGYONG("SsangYong"),
    SUBARU("Subaru"),
    SUZUKI("Suzuki"),
    ŠKODA("Škoda"),
    TALBOT("Talbot"),
    TATA("Tata"),
    TAVRIA("Tavria"),
    TOYOTA("Toyota"),
    TRABANT("Trabant"),
    TRIUMPH("Triumph"),
    UAZ("UAZ"),
    VAUXHALL("Vauxhall"),
    VOLKSWAGEN("Volkswagen"),
    VOLVO("Volvo"),
    WARTBURG("Wartburg"),
    ZASTAVA("Zastava"),
    ZHIDOU("ZhiDou"),
    OSTALO("Ostalo");

    private final String value;

    Brand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private static final Map<String, Brand> lookup = new HashMap<>();

    static {
        for (Brand brand : Brand.values()) {
            lookup.put(brand.getValue(), brand);
        }
    }

    public static Brand get(String brand) {
        return lookup.get(brand);
    }
}
