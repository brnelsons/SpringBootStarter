package com.bnelson.starter.domain.convert;

import com.google.common.base.Preconditions;
import com.google.common.collect.Streams;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public interface BiConverter<A, B> {
    B convertInternal(A a);

    A reverseInternal(B b);

    default B convert(@Nullable A a){
        return this.convertInternal(a);
    };
    default A reverse(@Nullable B b){
        return this.reverseInternal(b);
    };

    default Optional<B> convert(@Nonnull Optional<A> a) {
        Preconditions.checkNotNull(a, "convert argument A cannot be null");
        return a.map(this::convert);
    }

    default Optional<A> reverse(@Nonnull Optional<B> b) {
        Preconditions.checkNotNull(b, "reverse argument B cannot be null");
        return b.map(this::reverse);
    }

    default Stream<B> convertAll(Stream<A> a) {
        return a.map(this::convert);
    }

    default Stream<A> reverseAll(Stream<B> b) {
        return b.map(this::reverse);
    }

    default Iterable<B> convertAll(Iterable<A> a) {
        return convertAll(Streams.stream(a)).toList();
    }

    default Collection<A> reverseAll(Iterable<B> b) {
        return reverseAll(Streams.stream(b)).toList();
    }
}
