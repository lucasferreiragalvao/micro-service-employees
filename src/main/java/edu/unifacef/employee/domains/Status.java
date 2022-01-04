package edu.unifacef.employee.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    TRIAL(
            1D,
            "TRIAL",
            "Funcionário em periodo de experiência."
    ),
    WORKING(
            2D,
            "WORKING",
            "Funcionário exercendo sua função."
    ),
    VACATION(
            3D,
            "VACATION",
            "Funcionário em periodo de férias."
    ),
    AWAY(
            4D,
            "AWAY",
            "Funcionário afastado temporáriamente."
    ),
    FIRED(
            5D,
            "FIRED",
            "Funcionário demitido."
    );

    private final Double id;
    private final String key;
    private final String Description;
}
