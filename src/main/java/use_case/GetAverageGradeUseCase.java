package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

import java.util.ArrayList;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team team = gradeDB.getMyTeam();
        String[] members = team.getMembers();
        int sum = 0;

        for (int i = 0; i < 5; i++){
            sum += gradeDB.getGrade(members[i], course).getGrade();
        }
        return (float) sum /members.length;
    }
}
