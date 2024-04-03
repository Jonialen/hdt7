package org.example;

public class DictionaryTest {

    @Mock
    private BinaryTree<String, String> dictionary;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInsert() {
        when(dictionary.search("six")).thenReturn(null); // Simulando que no existe la asociación
        dictionary.insert("six", "seis");
        verify(dictionary).insert("six", "seis");
    }

    @Test
    public void testSearchExistingKey() {
        // Simulando que se encuentra la asociación
        when(dictionary.search("five")).thenReturn("five");
        assertEquals("five", dictionary.search("five"));
    }

    @Test
    public void testSearchNonExistingKey() {
        // Simulando que no se encuentra la asociación
        when(dictionary.search("one")).thenReturn(null);
        assertNull(dictionary.search("one"));
    }

    @Test
    public void testMainMethod() throws FileNotFoundException {
        File file = mock(File.class);
        Scanner scanner = mock(Scanner.class);
        when(file.exists()).thenReturn(true);
        when(file.getPath()).thenReturn("src\\main\\resources\\diccionario.txt");
        when(scanner.hasNextLine()).thenReturn(true, false);
        when(scanner.nextLine()).thenReturn("one, uno");

        Dictionary.main(new String[] {});

        verify(dictionary).insert("one", "uno");
    }
}
