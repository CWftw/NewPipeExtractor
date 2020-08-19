package org.schabi.newpipe.extractor.localization;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a country that should be used when fetching content.
 * <p>
 * YouTube, for example, give different results in their feed depending on which country is selected.
 * </p>
 */
public class ContentCountry implements Serializable {
    public static final ContentCountry DEFAULT = new ContentCountry(Localization.DEFAULT.getCountryCode());

    @NonNull private final String countryCode;

    public static List<ContentCountry> listFrom(String... countryCodeList) {
        final List<ContentCountry> toReturn = new ArrayList<>();
        for (String countryCode : countryCodeList) {
            toReturn.add(new ContentCountry(countryCode));
        }
        return Collections.unmodifiableList(toReturn);
    }

    public ContentCountry(@NonNull String countryCode) {
        this.countryCode = countryCode;
    }

    @NonNull
    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        return getCountryCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentCountry)) return false;

        ContentCountry that = (ContentCountry) o;

        return countryCode.equals(that.countryCode);
    }

    @Override
    public int hashCode() {
        return countryCode.hashCode();
    }
}
