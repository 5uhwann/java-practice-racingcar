package racingcar.domain.Referee;

import java.util.List;

public class FinalResult {

    private static final String INTRO = "최종 우승자 : ";
    private static final String PREFIX = ", ";

    private final String translatedWinners;

    public FinalResult(List<String> winners) {
        this.translatedWinners = translateWinners(winners);
    }

    public String getTranslatedWinners() {
        return translatedWinners;
    }

    private String translateWinners(List<String> winners) {
        StringBuilder translatedWinners = new StringBuilder(INTRO);
        for (int i = 0; i < winners.size(); i++) {
            translatedWinners.append(winners.get(i));
            if (i != winners.size() - 1) {
                translatedWinners.append(PREFIX);
            }
        }
        return translatedWinners.toString();
    }
}
