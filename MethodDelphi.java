package Methods;

public class MethodDelphi {
    private float[][] expertCompetence;
    private int[][] expertEvaluation;
    private float[] expertCompetenceLevels;
    private float[] optionImportance;
    private int[] optionRank;

    public MethodDelphi(float[][] expertCompetence, int[][] expertEvaluation){
        this.expertCompetence = expertCompetence;
        this.expertEvaluation = expertEvaluation;
        this.expertCompetenceLevels = new float[expertCompetence.length];
        this.optionImportance = new float[expertEvaluation[0].length];
        this.optionRank = new int[expertEvaluation[0].length];
    }

    public float[] getArgumentLevel(){
        for(int i = 0; i < expertCompetence.length; i++){
            for(int j = 1; j < expertCompetence[0].length; j++){
                expertCompetenceLevels[i] += expertCompetence[i][j];
            }
            expertCompetenceLevels[i] += expertCompetence[i][0] * 0.1f;
            expertCompetenceLevels[i] /= 2;
        }

        return expertCompetenceLevels;
    }

    public float[] getMessageImportance(){
        for(int j = 0; j < expertEvaluation[0].length; j++){
            for(int i = 0; i < expertEvaluation.length; i++){
                optionImportance[j] += expertCompetenceLevels[i] * expertEvaluation[i][j];
            }
            optionImportance[j] /= expertEvaluation.length;
        }
        return optionImportance;
    }

    public int[] getMessageRank(){
        int rank = 1;
        for(int i = 0; i < optionImportance.length; i++){
            int index = getMaxOption();
            optionRank[index] = rank;
            rank++;
        }
        return optionRank;
    }

    private int getMaxOption(){
        float maxOption;
        int maxOptionIndex = -1;
        for (int i = 0; i < optionImportance.length; i++){
            if(optionRank[i] == 0){
                maxOption = optionImportance[i];
                for (int j = i; j < optionImportance.length; j++){
                    if((optionImportance[j] >= maxOption) && (optionRank[j] == 0)) {
                        maxOption = optionImportance[j];
                        maxOptionIndex = j;
                    }
                }
                return maxOptionIndex;
            }
        }
        return maxOptionIndex;
    }

}
