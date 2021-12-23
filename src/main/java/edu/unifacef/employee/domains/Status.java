package edu.unifacef.employee.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {

    TRIAL(
            1D,
            "Trial Period",
            "Funcionário em periodo de experiência."
    ),
    WORKING(
            2D,
            "Working",
            "Funcionário exercendo sua função."
    ),
    VACATION(
            3D,
            "Vacation",
            "Funcionário em periodo de férias."
    ),
    AWAY(
            4D,
            "Away",
            "Funcionário afastado temporáriamente."
    ),
    FIRED(
            5D,
            "Fired",
            "Funcionário demitido."
    );

    private final Double id;
    private final String key;
    private final String Description;
}
