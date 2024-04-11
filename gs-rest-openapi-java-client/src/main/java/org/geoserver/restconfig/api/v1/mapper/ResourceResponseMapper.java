package org.geoserver.restconfig.api.v1.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.geoserver.openapi.model.catalog.KeywordInfo;
import org.geoserver.openapi.model.catalog.NamespaceInfo;
import org.geoserver.openapi.v1.model.*;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

public interface ResourceResponseMapper {
    @Mapping(source = "name", target = "prefix")
    @Mapping(source = "href", target = "uri")
    NamespaceInfo namedLinkToNamespaceInfo(NamedLink l);

    default List<String> stringArrayResponseToStringList(StringArrayResponse r) {
        return r == null || r.getValues() == null ? null : new ArrayList<String>(r.getValues());
    }

    default StringArrayResponse stringListToStringArrayResponse(List<String> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        return new StringArrayResponse(values);
    }

    default List<KeywordInfo> resourceResponseKeywordsToKeywordInfoList(ResourceResponseKeywords r) {

        return r == null || r.getString() == null
                ? null
                : r.getString().stream().map(this::stringToKeywordInfo).collect(Collectors.toList());
    }

    default ResourceResponseKeywords keywordInfoListToResourceResponseKeyWords(List<KeywordInfo> r) {
        if(r == null || r.isEmpty()) {
            return null;
        }
        List<String> collect = r.stream().map(KeywordInfo::getValue).collect(Collectors.toList());
        return new ResourceResponseKeywords(collect);
    }

    default List<Double> doubleArrayResponsemapDoubleList(DoubleArrayResponse value) {
        if (value == null || value.getValues() == null) {
            return null;
        }
        return new ArrayList<>(value.getValues());
    }

    default DoubleArrayResponse listDoubleTODoubleArrayResponse(List<Double> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        return new DoubleArrayResponse(values);
    }

    default Double stringToDouble(String value) {
        if (value == null) {
            return null;
        }
        if ("inf".equals(value)) {
            return Double.POSITIVE_INFINITY;
        }
        if ("-inf".equals(value)) {
            return Double.NEGATIVE_INFINITY;
        }
        return Double.parseDouble(value);
    }

    default List<Integer> integerArrayResponseToIntegerList(IntegerArrayResponse value) {
        if (value == null || value.getValues() == null) {
            return null;
        }
        return new ArrayList<>(value.getValues());
    }

    default IntegerArrayResponse integerListToIntegerArrayResponse(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }
        return new IntegerArrayResponse(values);
    }

    default KeywordInfo stringToKeywordInfo(String s) {
        if (s == null) {
            return null;
        }
        KeywordInfo ki = new KeywordInfo();
        if (-1 == s.indexOf(';')) {
            ki.value(s);
        } else {
            String spec = s.replace("\\", "").replace(";", "");
            String[] split = spec.split("@");
            ki.value(split[0]);
            for (int i = 1; i < split.length; i++) {
                String kv = split[i];
                String[] kvc = kv.split("=");
                if (kvc.length == 2) {
                    final String k = kvc[0];
                    String v = kvc[1];
                    if ("language".equals(k)) {
                        ki.language(v);
                    } else if ("vocabulary".equals(k)) {
                        ki.vocabulary(v);
                    }
                }
            }
        }
        return ki;
    }

    default String crsObjectToString(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        if (value instanceof Map) {
            return (String) ((Map) value).get("$");
        }
        throw new IllegalStateException();
    }
}
