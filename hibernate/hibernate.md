# Objectives

- model entities and use special types
- create association between entities

# JPA

java persistence api (Jakarta)
EntityManagerFactory EntityManager Entity Query TransactionManager EntityTransaction

# Hibernate

- ORM - object relational mapper
- SessionFactory
- Session
- Transaction
- Entity
- Query

# configuration

TODO configure hibernate with mysql

    HibernateUtil

# JPA model

on entity

- @Entity
- @Table

on field

- @Id
- @NaturalId
- @GeneratedValue
- @Column

- @Embedded, @Embeddable
- @EmbeddedId , @IdClass

- @Basic
- @Type
- @Formula
- @ElementCollection
- @Transient
- @Lob
- @Enumerated

# hibernate CRUD

TODO create crud dao using hibernate

    Person
    PersonRepository
    DemoCrud

# special types

TODO use special types

    @Enumerated
    @Embedded
    Player
    PlayerRepository
    DemoHibernateTypes

# transaction management

TODO handle transactions programmatically

    DemoTransactionManagement

# associations

TODO create objects with associations

    @OneToOne
      Car
      Parking

    @OneToOne join
      Account
      Employee

    @OneToMany unidirectional
      Mother
      Daughter
      MotherDao
      DemoOneToManyUnidirectional

    @OneToMany unidirectional
      @JoinColumn
      Father
      Son
      FatherDao
      DemoOneToManyUnidirectionalJoin
  
    @OneToMany bidirectional
      Parent
      Child
      ParentDao
      DemoOneToManyBidirectional
  
    @ManyToMany
      @JoinTable
      Post
      Tag
      PostDao
      DemoManyToMany

# fetch eager vs lazy

    FetchType

# queries

- HQL queries

TODO write queries using hql

    Stock
    StockDao
    DemoHqlQuery

- HQL queries join fetch

TODO write queries using hql join

    Author
    Book
    AuthorDao
    DemoHqlJoin

- native queries

TODO write queries using native sql

        Trader
        TraderDao
        DemoNativeQuery

# session methods

- standard jpa methods

      persist()
      evict()
      merge()
      flush()
      delete()
    
      DemoEvictAndMerge

- non-standard hibernate methods

      save()
      update()
      saveOrUpdate()

- find in database

      find()  // recommended
      byId()  // more flexible than get() and load()
      byNaturalId()   // find an entity by natural id

      get()   // hits the database
      load()  // doesn't hit the database

      contains() // checks existence of entity

- queries for the database

      createQuery()
      createNamedQuery()

# audit

TODO use callbacks to add history for audit

    Customer
    CustomerRepository
    
    Action
    CustomerHistory
    CustomerHistoryListener
    CustomerHistoryRepository
    DemoListeners

on entity

    @EntityListeners

on listener methods

    @PrePersist
    @PostPersist

    @PreUpdate
    @PostUpdate

    @PreRemove
    @PostRemove
