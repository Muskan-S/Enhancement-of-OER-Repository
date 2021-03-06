/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.eperson;

import org.dspace.content.Collection;
import org.dspace.core.Context;
import org.dspace.core.ReloadableEntity;

import javax.persistence.*;

/**
 * Database entity representation of the subscription table
 *
 * @author kevinvandevelde at atmire.com
 */
@Entity
@Table(name = "mycourse")
public class Mycourse implements ReloadableEntity<Integer> {

    @Id
    @Column(name = "course_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="course_seq")
    @SequenceGenerator(name="course_seq", sequenceName="subscription_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eperson_id")
    private EPerson ePerson;

    /**
     * Protected constructor, create object using:
     * {@link org.dspace.eperson.service.SubscribeService#subscribe(Context, EPerson, Collection)}
     *
     */
    public Mycourse()
    {

    }

    public Integer getID() {
        return id;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public EPerson getePerson() {
        return ePerson;
    }

    public void setePerson(EPerson ePerson) {
        this.ePerson = ePerson;
    }
}
