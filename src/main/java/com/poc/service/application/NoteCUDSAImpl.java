package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.domain.Note;
import com.poc.model.dto.NoteDTO;
import com.poc.mapper.NoteMapper;
import com.poc.service.business.NoteCUDSM;
import com.poc.service.business.NoteRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteCUDSAImpl implements NoteCUDSA {

    private final NoteCUDSM noteCUDSM;
    private final NoteRSM noteRSM;
    private final NoteMapper noteMapper;

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        if (noteDTO == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_NOTE_OBJECT_EMPTY.getErrorMessage());
        }
        return noteMapper.toDTO(noteCUDSM.createOrUpdateNote(noteMapper.toDO(noteDTO)));
    }

    @Override
    public List<NoteDTO> saveAllNotes(List<NoteDTO> notes) {
        return noteMapper.toDTO(noteCUDSM.saveAllNotes(noteMapper.toDO(notes)));
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        if (noteDTO == null || noteDTO.getId() == null) {
            throw new FunctionalException(ErrorsEnum.ERR_MCS_NOTE_OBJECT_EMPTY.getErrorMessage());
        }
        NoteDTO noteFound = noteMapper.toDTO(noteRSM.getNoteById(noteDTO.getId()));
        noteFound.setTitle(noteDTO.getTitle());
        noteFound.setContent(noteDTO.getContent());
        return noteMapper.toDTO(noteCUDSM.createOrUpdateNote(noteMapper.toDO(noteFound)));
    }

    @Override
    public void deleteNoteById(Long id) {
        noteCUDSM.deleteNoteById(id);
    }
}
