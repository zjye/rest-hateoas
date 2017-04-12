package hello;

import java.util.List;

public class Student extends Person {
    private List<ExamResult> examResults;

    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<ExamResult> examResults) {
        this.examResults = examResults;
    }
}
