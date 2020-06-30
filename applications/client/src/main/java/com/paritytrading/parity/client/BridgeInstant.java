package com.paritytrading.parity.client;

/*
 * DIFFERS from java.time.Instant due to JSON serialization issues
 * 
 * Used in CtsInterval.java
 */

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import com.paritytrading.foundation.ASCII;

public class BridgeInstant {
	private String instantString = new String("");
	private static final DateTimeFormatter INSTANT_INSTRUMENT_FORMATTER =
			DateTimeFormatter.ofPattern("MMddHHmm").withZone(ZoneId.of("Z"));

	BridgeInstant() {
	}

	BridgeInstant(Instant javaInstant) {
		instantString = javaInstant.toString();
	}

	Instant asInstant() {
		return Instant.parse(instantString);
	}

	@Override
	public String toString()	{
		return "BridgeInstant" + asInstant().toString();
	}
	
	public String getInstantString() {
		return instantString;
	}

	public void setInstantString(String instantString) {
		this.instantString = instantString;
	}

	/**
	 * Converts dtStart to a packed long using {@link ASCII}.
	 * 
	 * @return packed long
	 */
	public long toPackedLong() {
		return ASCII.packLong(INSTANT_INSTRUMENT_FORMATTER.format(this.asInstant()));
	}

	/**
	 * Converts {@link #dtStart} to an instrument name.
	 * 
	 * @return string matching the form {@code MMddHHmm}
	 */
	public String toInstrumentName() {
		return INSTANT_INSTRUMENT_FORMATTER.format(this.asInstant());
	}

}
