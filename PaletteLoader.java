// Author: Jay Sheridan
// Class to load JIU palettes from a text file
// 9/7/2003

/*
Some notes (from the fl4sc attempt):
-If it errors anywhere, try returning a vector with a null first item.
-The second item can then be a string with the error message.
-Otherwise can possibly alternate Palette object and name String or other info.
-Takes a buffered reader as an argument instead of a file.
-File opening would be done by whatever calls this function.

Newer notes:
-Loading a palette would be done one at a time.
  -GetNext() type function would read in the next palette and store
   it in memory for the main program to copy. Name would also be stored
   this way.
  -errored items could be saved as null while throwing an IOerror. May not
   be needed with second format idea.
*/

/*
Format ideas:
Original..
';' is a comment character
name = PalName  *Find the word "name" and use all remaning tokens as name?
#,#,#,#,"type"  *Palette loc., R, G, B, blend type
step, #,#,#     *is a blend type, Step, delta R, delta G, delta B
solid           *stays the same color
blend           *blends with previous (or next?)

New..
; Built more like ini files. Read in palette order, 0 - #colors.
; Default blend type would probably be "solid". 0 default would
; be black. #colors default would be the last color entered.
; Possible additional blend type: hsiblend
[Directory,Name,Colors?]
# # # #         ; index num, R, G, B
type <of blend>
; comment characters are ';' again
*/

import net.sourceforge.jiu.data.Palette;
import java.io.BufferedReader;
import java.lang.String;
import java.util.StringTokenizer;

public class PaletteLoader
{
    private Palette currentPalette;
    private String currentName, currentDirectory
    private BufferedReader paletteReader;
    private int entriesPerPalette;

    public PaletteLoader()
    {
	paletteReader = null;
	currentPalette = null;
	currentName = "";
	currentDirectory = "";
	entriesPerPalette = 256;
    }

    public PaletteLoader(BufferedReader palRead)
    {
	PaletteLoader();
	paletteReader = palRead;
    }

    public PaletteLoader(BufferedReader palRead, int entries)
    {
	PaletteLoader();
	paletteReader = palRead;
	entriesPerPalette = entries;
    }

    public Palette getCurrentPalette()
    {
	return currentPalette;
    }

    public String getCurrentName()
    {
	return currentName;
    }

    public String getCurrentDirectory()
    {
	return currentDirectory();
    }

    public int getEntriesPerPalette()
    {
	return entriesPerPalette;
    }

    public void setBufferedReader(BufferedReader r)
    {
	paletteReader = r;
    }

    public void setEntriesPerPalette(int entries)
    {
	entriesPerPalette = entries;
    }

    public boolean readNextPalette()
    {
	String thisLine = "";
	StringTokenizer tokenizer;

	if (paletteReader == null) {
	    currentName = "Buffered Reader is null.";
	    return false;
	}
	else {
	    try {
		while (paletteReader.ready()) {
		    thisLine = paletteReader.readLine();
		    if (thisLine.charAt(0) != ';') {

		    }
		}
	    }
	    catch (EOFException e)
		{ ; } // do nothing, EOF is ok.
	}
    }

} // end class
