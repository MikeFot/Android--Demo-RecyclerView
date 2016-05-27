package com.michaelfotiadis.demorecyclerview.core.data.parsers;

import com.michaelfotiadis.demorecyclerview.core.models.album.Album;
import com.michaelfotiadis.demorecyclerview.core.models.album.AlbumImpl;

import java.util.HashSet;
import java.util.Set;

/* package */ final class TypeAdapterFactoryCreator {

    private static final String JSON_TYPE_FIELD = "gsonObjectType";
    private final Set<RuntimeTypeAdapterFactory> adapters;
    private final Set<Class<?>> baseTypes = new HashSet<>();
    private final Set<Class<?>> subTypes = new HashSet<>();

    public TypeAdapterFactoryCreator() {
        adapters = new HashSet<>();

        // add pairings for interface - implementation
        adapters.add(create(Album.class, AlbumImpl.class));

    }

    private <T> RuntimeTypeAdapterFactory create(final Class<T> baseType,
                                                 final Class<? extends T> subType) {
        final String subTypeName = subType.getSimpleName();

        if (!baseTypes.add(baseType)) {
            throw new IllegalStateException("You have already added BaseType " + baseType.getName());
        }

        if (!subTypes.add(subType)) {
            throw new IllegalStateException("You have already added SubType " + subType.getName());
        }

        return RuntimeTypeAdapterFactory
                .of(baseType, subTypeName, JSON_TYPE_FIELD)
                .registerSubtype(subType, subTypeName);
    }


    /**
     * Generates a collection of {@link RuntimeTypeAdapterFactory}
     *
     * @return {@link Set} of {@link RuntimeTypeAdapterFactory}
     */
    public Set<RuntimeTypeAdapterFactory> getAdapters() {
        return adapters;
    }

}