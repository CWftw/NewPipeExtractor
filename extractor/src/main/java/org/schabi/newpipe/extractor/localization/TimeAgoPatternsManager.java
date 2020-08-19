package org.schabi.newpipe.extractor.localization;

import org.schabi.newpipe.extractor.timeago.PatternsHolder;
import org.schabi.newpipe.extractor.timeago.PatternsManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TimeAgoPatternsManager {
    @Nullable
    private static PatternsHolder getPatternsFor(@NonNull Localization localization) {
        return PatternsManager.getPatterns(localization.getLanguageCode(), localization.getCountryCode());
    }

    @Nullable
    public static TimeAgoParser getTimeAgoParserFor(@NonNull Localization localization) {
        final PatternsHolder holder = getPatternsFor(localization);

        if (holder == null) {
            return null;
        }

        return new TimeAgoParser(holder);
    }
}
