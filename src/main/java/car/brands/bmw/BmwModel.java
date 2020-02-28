package car.brands.bmw;

import car.brands.Brand;

import java.util.HashMap;
import java.util.Map;

public enum BmwModel {
    BMW_SERIJA_1("serija-1"),
    BMW_114("114"),
    BMW_116("116"),
    BMW_118("118"),
    BMW_120("120"),
    BMW_123("123"),
    BMW_125("125"),
    BMW_135("135"),
    BMW_SERIJA_2("serija-2"),
    BMW_214("214"),
    BMW_216("216"),
    BMW_218("218"),
    BMW_220("220"),
    BMW_SERIJA_3("serija-3"),
    BMW_315("315"),
    BMW_316("316"),
    BMW_318("318"),
    BMW_320("320"),
    BMW_323("323"),
    BMW_324("324"),
    BMW_325("325"),
    BMW_328("328"),
    BMW_330("330"),
    BMW_335("335"),
    BMW_COMPACT("compact"),
    BMW_SERIJA_3_GT("serija-3-gt"),
    BMW_318_GT("318-gt"),
    BMW_320_GT("320-gt"),
    BMW_SERIJA_4("serija-4"),
    BMW_418("418"),
    BMW_420("420"),
    BMW_428("428"),
    BMW_430("430"),
    BMW_435("435"),
    BMW_SERIJA_5("serija-5"),
    BMW_518("518"),
    BMW_520("520"),
    BMW_523("523"),
    BMW_524("524"),
    BMW_525("525"),
    BMW_528("528"),
    BMW_530("530"),
    BMW_535("535"),
    BMW_540("540"),
    BMW_M550("m550"),
    BMW_SERIJA_5_GT("serija-5-gt"),
    BMW_520_GT("520-gt"),
    BMW_530_GT("530-gt"),
    BMW_SERIJA_6("serija-6"),
    BMW_630("630"),
    BMW_635("635"),
    BMW_640("640"),
    BMW_645("645"),
    BMW_650("650"),
    BMW_SERIJA_7("serija-7"),
    BMW_725("725"),
    BMW_728("728"),
    BMW_730("730"),
    BMW_735("735"),
    BMW_740("740"),
    BMW_745("745"),
    BMW_750("750"),
    BMW_SERIJA_8("serija-8"),
    BMW_840("840"),
    BMW_850("850"),
    BMW_SERIJA_M("serija-m"),
    BMW_M2("m2"),
    BMW_M3("m3"),
    BMW_M4("m4"),
    BMW_M5("m5"),
    BMW_M6("m6"),
    BMW_SERIJA_X("serija-x"),
    BMW_X1("x1"),
    BMW_X2("x2"),
    BMW_X3("x3"),
    BMW_X4("x4"),
    BMW_X5("x5"),
    BMW_X6("x6"),
    BMW_X7("x7"),
    BMW_SERIJA_I("serija-i"),
    BMW_I3("i3"),
    BMW_I8("i8"),
    BMW_SERIJA_Z("serija-z"),
    BMW_Z3("z3"),
    BMW_Z4("z4"),
    BMW_OSTALO("ostalo");

    private final String model;

    BmwModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    private static final Map<String, BmwModel> lookup = new HashMap<>();

    static {
        for (BmwModel model : BmwModel.values()) {
            lookup.put(model.getModel(), model);
        }
    }

    public static BmwModel get(String bmwModel) {
        return lookup.get(bmwModel);
    }
}
