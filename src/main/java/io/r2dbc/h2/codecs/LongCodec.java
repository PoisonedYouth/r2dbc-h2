/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.r2dbc.h2.codecs;

import org.h2.value.Value;
import org.h2.value.ValueLong;

import java.util.Objects;

/**
 * @author Greg Turnquist
 */
final class LongCodec extends AbstractCodec<Long> {

    LongCodec() {
        super(Long.class);
    }

    @Override
    boolean doCanDecode(int dataType) {
        return dataType == Value.LONG;
    }

    @Override
    Long doDecode(Value value, Class<? extends Long> type) {
        return value.getLong();
    }

    @Override
    Value doEncode(Long value) {
        return ValueLong.get(Objects.requireNonNull(value, "value must not be null"));
    }
}
