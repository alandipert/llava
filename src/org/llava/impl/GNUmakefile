# Copyright (c) 1997 - 2004 Harold Carr
#
# This work is licensed under the Creative Commons Attribution License.
# To view a copy of this license, visit 
#   http://creativecommons.org/licenses/by/2.0/
# or send a letter to
#   Creative Commons, 559 Nathan Abbott Way, Stanford, California 94305, USA.
#-----------------------------------------------------------------------------

#
# Created       : 1999 Dec 15 (Wed) 16:30:21 by Harold Carr.
# Last Modified : 2004 Dec 07 (Tue) 18:43:53 by Harold Carr.
#

TOPDIR		=	../../..

PACKAGE		=	org.llava.impl
PKGDIR		=	org/llava/impl

FILES_java	= \
	$(PKGDIR)/LambdaImpl.java \
	$(PKGDIR)/LlavaVersionImpl.java \
	$(PKGDIR)/PairImpl.java \
	$(PKGDIR)/ReplImpl.java \
	$(PKGDIR)/SymbolImpl.java

all :: classes 

SUBDIRS		=	compiler io procedure runtime syntax util

all optimized debug clean clobber ::
	@for i in $(SUBDIRS) ; do \
	    echo ">>>Recursively making "$$i" "$@"..."; \
	    cd $$i; $(MAKE) $@ || exit 1; cd ..;  \
	    echo "<<<Finished Recursively making "$$i" "$@"." ; \
	done

hcMakefiles=$(shell hcMakefiles)
include $(hcMakefiles)/javaDefs.gmk
include $(hcMakefiles)/javaRules.gmk

# End of file.
