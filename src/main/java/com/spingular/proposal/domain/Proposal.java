package com.spingular.proposal.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.spingular.proposal.domain.enumeration.ProposalType;

import com.spingular.proposal.domain.enumeration.ProposalRole;

/**
 * A Proposal.
 */
@Entity
@Table(name = "proposal")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Proposal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "creation_date", nullable = false)
    private Instant creationDate;

    @NotNull
    @Size(min = 2, max = 250)
    @Column(name = "proposal_name", length = 250, nullable = false)
    private String proposalName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "proposal_type", nullable = false)
    private ProposalType proposalType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "proposal_role", nullable = false)
    private ProposalRole proposalRole;

    @Column(name = "release_date")
    private Instant releaseDate;

    @Column(name = "is_open")
    private Boolean isOpen;

    @Column(name = "is_accepted")
    private Boolean isAccepted;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @OneToMany(mappedBy = "proposal")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<VoteProposal> voteProposals = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("proposals")
    private Profile profile;

    @ManyToOne
    @JsonIgnoreProperties("proposals")
    private Post post;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public Proposal creationDate(Instant creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getProposalName() {
        return proposalName;
    }

    public Proposal proposalName(String proposalName) {
        this.proposalName = proposalName;
        return this;
    }

    public void setProposalName(String proposalName) {
        this.proposalName = proposalName;
    }

    public ProposalType getProposalType() {
        return proposalType;
    }

    public Proposal proposalType(ProposalType proposalType) {
        this.proposalType = proposalType;
        return this;
    }

    public void setProposalType(ProposalType proposalType) {
        this.proposalType = proposalType;
    }

    public ProposalRole getProposalRole() {
        return proposalRole;
    }

    public Proposal proposalRole(ProposalRole proposalRole) {
        this.proposalRole = proposalRole;
        return this;
    }

    public void setProposalRole(ProposalRole proposalRole) {
        this.proposalRole = proposalRole;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    public Proposal releaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public void setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean isIsOpen() {
        return isOpen;
    }

    public Proposal isOpen(Boolean isOpen) {
        this.isOpen = isOpen;
        return this;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Boolean isIsAccepted() {
        return isAccepted;
    }

    public Proposal isAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
        return this;
    }

    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Boolean isIsPaid() {
        return isPaid;
    }

    public Proposal isPaid(Boolean isPaid) {
        this.isPaid = isPaid;
        return this;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Set<VoteProposal> getVoteProposals() {
        return voteProposals;
    }

    public Proposal voteProposals(Set<VoteProposal> voteProposals) {
        this.voteProposals = voteProposals;
        return this;
    }

    public Proposal addVoteProposal(VoteProposal voteProposal) {
        this.voteProposals.add(voteProposal);
        voteProposal.setProposal(this);
        return this;
    }

    public Proposal removeVoteProposal(VoteProposal voteProposal) {
        this.voteProposals.remove(voteProposal);
        voteProposal.setProposal(null);
        return this;
    }

    public void setVoteProposals(Set<VoteProposal> voteProposals) {
        this.voteProposals = voteProposals;
    }

    public Profile getProfile() {
        return profile;
    }

    public Proposal profile(Profile profile) {
        this.profile = profile;
        return this;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Post getPost() {
        return post;
    }

    public Proposal post(Post post) {
        this.post = post;
        return this;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Proposal)) {
            return false;
        }
        return id != null && id.equals(((Proposal) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Proposal{" +
            "id=" + getId() +
            ", creationDate='" + getCreationDate() + "'" +
            ", proposalName='" + getProposalName() + "'" +
            ", proposalType='" + getProposalType() + "'" +
            ", proposalRole='" + getProposalRole() + "'" +
            ", releaseDate='" + getReleaseDate() + "'" +
            ", isOpen='" + isIsOpen() + "'" +
            ", isAccepted='" + isIsAccepted() + "'" +
            ", isPaid='" + isIsPaid() + "'" +
            "}";
    }
}
