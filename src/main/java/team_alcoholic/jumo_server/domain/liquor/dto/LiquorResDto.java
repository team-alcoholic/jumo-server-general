package team_alcoholic.jumo_server.domain.liquor.dto;

import lombok.Builder;
import team_alcoholic.jumo_server.domain.liquor.domain.Liquor;
import team_alcoholic.jumo_server.domain.tastingnote.dto.AiNotesResDTO;
import team_alcoholic.jumo_server.domain.user.domain.User;
import team_alcoholic.jumo_server.domain.user.dto.UserResDTO;

public record LiquorResDto(
        Long id,
        String thumbnailImageUrl,
        String koName,
        String enName,
        String type,
        String abv,
        String volume,
        String country,
        String region,
        String grapeVariety,
        String tastingNotesAroma,
        String tastingNotesTaste,
        String tastingNotesFinish,
        AiNotesResDTO aiNotes,
        String createdAt,
        String updatedAt,
        String createdBy,
        String updatedBy,
        UserResDTO user
) {

    @Builder
    public LiquorResDto {
    }

    public static LiquorResDto fromEntity(Liquor liquor) {
        return LiquorResDto.builder()
                .id(liquor.getId())
                .thumbnailImageUrl(liquor.getThumbnailImageUrl())
                .koName(liquor.getKoName())
                .enName(liquor.getEnName())
                .type(liquor.getType())
                .abv(liquor.getAbv())
                .volume(liquor.getVolume())
                .country(liquor.getCountry())
                .region(liquor.getRegion())
                .grapeVariety(liquor.getGrapeVariety())
                .tastingNotesAroma(liquor.getTastingNotesAroma())
                .tastingNotesTaste(liquor.getTastingNotesTaste())
                .tastingNotesFinish(liquor.getTastingNotesFinish())
                .aiNotes(AiNotesResDTO.fromEntity(liquor.getAiTastingNote()))
                .createdAt(liquor.getCreatedAt().toString())
                .updatedAt(liquor.getUpdatedAt().toString())
                .createdBy("dailyshot".equals(liquor.getCreatedBy()) ? "jumo" : liquor.getCreatedBy())
                .updatedBy("dailyshot".equals(liquor.getUpdatedBy()) ? "jumo" : liquor.getUpdatedBy())
                .user(UserResDTO.fromEntity(liquor.getUser()))
                .build();
    }
}