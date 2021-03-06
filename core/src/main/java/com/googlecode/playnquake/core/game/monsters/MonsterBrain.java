/*
 * Copyright (C) 1997-2001 Id Software, Inc.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 *  
 */
/* Modifications
   Copyright 2003-2004 Bytonic Software
   Copyright 2010 Google Inc.
*/
package com.googlecode.playnquake.core.game.monsters;

import com.googlecode.playnquake.core.common.Constants;
import com.googlecode.playnquake.core.game.*;
import com.googlecode.playnquake.core.game.adapters.EntInteractAdapter;
import com.googlecode.playnquake.core.game.adapters.EntityDieAdapter;
import com.googlecode.playnquake.core.game.adapters.EntityDodgeAdapter;
import com.googlecode.playnquake.core.game.adapters.EntityPainAdapter;
import com.googlecode.playnquake.core.game.adapters.EntityThinkAdapter;
import com.googlecode.playnquake.core.server.ServerGame;
import com.googlecode.playnquake.core.server.ServerInit;
import com.googlecode.playnquake.core.server.World;
import com.googlecode.playnquake.core.util.Lib;
import com.googlecode.playnquake.core.util.Math3D;


public class MonsterBrain {

    public final static int FRAME_walk101 = 0;

    public final static int FRAME_walk102 = 1;

    public final static int FRAME_walk103 = 2;

    public final static int FRAME_walk104 = 3;

    public final static int FRAME_walk105 = 4;

    public final static int FRAME_walk106 = 5;

    public final static int FRAME_walk107 = 6;

    public final static int FRAME_walk108 = 7;

    public final static int FRAME_walk109 = 8;

    public final static int FRAME_walk110 = 9;

    public final static int FRAME_walk111 = 10;

    public final static int FRAME_walk112 = 11;

    public final static int FRAME_walk113 = 12;

    public final static int FRAME_walk201 = 13;

    public final static int FRAME_walk202 = 14;

    public final static int FRAME_walk203 = 15;

    public final static int FRAME_walk204 = 16;

    public final static int FRAME_walk205 = 17;

    public final static int FRAME_walk206 = 18;

    public final static int FRAME_walk207 = 19;

    public final static int FRAME_walk208 = 20;

    public final static int FRAME_walk209 = 21;

    public final static int FRAME_walk210 = 22;

    public final static int FRAME_walk211 = 23;

    public final static int FRAME_walk212 = 24;

    public final static int FRAME_walk213 = 25;

    public final static int FRAME_walk214 = 26;

    public final static int FRAME_walk215 = 27;

    public final static int FRAME_walk216 = 28;

    public final static int FRAME_walk217 = 29;

    public final static int FRAME_walk218 = 30;

    public final static int FRAME_walk219 = 31;

    public final static int FRAME_walk220 = 32;

    public final static int FRAME_walk221 = 33;

    public final static int FRAME_walk222 = 34;

    public final static int FRAME_walk223 = 35;

    public final static int FRAME_walk224 = 36;

    public final static int FRAME_walk225 = 37;

    public final static int FRAME_walk226 = 38;

    public final static int FRAME_walk227 = 39;

    public final static int FRAME_walk228 = 40;

    public final static int FRAME_walk229 = 41;

    public final static int FRAME_walk230 = 42;

    public final static int FRAME_walk231 = 43;

    public final static int FRAME_walk232 = 44;

    public final static int FRAME_walk233 = 45;

    public final static int FRAME_walk234 = 46;

    public final static int FRAME_walk235 = 47;

    public final static int FRAME_walk236 = 48;

    public final static int FRAME_walk237 = 49;

    public final static int FRAME_walk238 = 50;

    public final static int FRAME_walk239 = 51;

    public final static int FRAME_walk240 = 52;

    public final static int FRAME_attak101 = 53;

    public final static int FRAME_attak102 = 54;

    public final static int FRAME_attak103 = 55;

    public final static int FRAME_attak104 = 56;

    public final static int FRAME_attak105 = 57;

    public final static int FRAME_attak106 = 58;

    public final static int FRAME_attak107 = 59;

    public final static int FRAME_attak108 = 60;

    public final static int FRAME_attak109 = 61;

    public final static int FRAME_attak110 = 62;

    public final static int FRAME_attak111 = 63;

    public final static int FRAME_attak112 = 64;

    public final static int FRAME_attak113 = 65;

    public final static int FRAME_attak114 = 66;

    public final static int FRAME_attak115 = 67;

    public final static int FRAME_attak116 = 68;

    public final static int FRAME_attak117 = 69;

    public final static int FRAME_attak118 = 70;

    public final static int FRAME_attak201 = 71;

    public final static int FRAME_attak202 = 72;

    public final static int FRAME_attak203 = 73;

    public final static int FRAME_attak204 = 74;

    public final static int FRAME_attak205 = 75;

    public final static int FRAME_attak206 = 76;

    public final static int FRAME_attak207 = 77;

    public final static int FRAME_attak208 = 78;

    public final static int FRAME_attak209 = 79;

    public final static int FRAME_attak210 = 80;

    public final static int FRAME_attak211 = 81;

    public final static int FRAME_attak212 = 82;

    public final static int FRAME_attak213 = 83;

    public final static int FRAME_attak214 = 84;

    public final static int FRAME_attak215 = 85;

    public final static int FRAME_attak216 = 86;

    public final static int FRAME_attak217 = 87;

    public final static int FRAME_pain101 = 88;

    public final static int FRAME_pain102 = 89;

    public final static int FRAME_pain103 = 90;

    public final static int FRAME_pain104 = 91;

    public final static int FRAME_pain105 = 92;

    public final static int FRAME_pain106 = 93;

    public final static int FRAME_pain107 = 94;

    public final static int FRAME_pain108 = 95;

    public final static int FRAME_pain109 = 96;

    public final static int FRAME_pain110 = 97;

    public final static int FRAME_pain111 = 98;

    public final static int FRAME_pain112 = 99;

    public final static int FRAME_pain113 = 100;

    public final static int FRAME_pain114 = 101;

    public final static int FRAME_pain115 = 102;

    public final static int FRAME_pain116 = 103;

    public final static int FRAME_pain117 = 104;

    public final static int FRAME_pain118 = 105;

    public final static int FRAME_pain119 = 106;

    public final static int FRAME_pain120 = 107;

    public final static int FRAME_pain121 = 108;

    public final static int FRAME_pain201 = 109;

    public final static int FRAME_pain202 = 110;

    public final static int FRAME_pain203 = 111;

    public final static int FRAME_pain204 = 112;

    public final static int FRAME_pain205 = 113;

    public final static int FRAME_pain206 = 114;

    public final static int FRAME_pain207 = 115;

    public final static int FRAME_pain208 = 116;

    public final static int FRAME_pain301 = 117;

    public final static int FRAME_pain302 = 118;

    public final static int FRAME_pain303 = 119;

    public final static int FRAME_pain304 = 120;

    public final static int FRAME_pain305 = 121;

    public final static int FRAME_pain306 = 122;

    public final static int FRAME_death101 = 123;

    public final static int FRAME_death102 = 124;

    public final static int FRAME_death103 = 125;

    public final static int FRAME_death104 = 126;

    public final static int FRAME_death105 = 127;

    public final static int FRAME_death106 = 128;

    public final static int FRAME_death107 = 129;

    public final static int FRAME_death108 = 130;

    public final static int FRAME_death109 = 131;

    public final static int FRAME_death110 = 132;

    public final static int FRAME_death111 = 133;

    public final static int FRAME_death112 = 134;

    public final static int FRAME_death113 = 135;

    public final static int FRAME_death114 = 136;

    public final static int FRAME_death115 = 137;

    public final static int FRAME_death116 = 138;

    public final static int FRAME_death117 = 139;

    public final static int FRAME_death118 = 140;

    public final static int FRAME_death201 = 141;

    public final static int FRAME_death202 = 142;

    public final static int FRAME_death203 = 143;

    public final static int FRAME_death204 = 144;

    public final static int FRAME_death205 = 145;

    public final static int FRAME_duck01 = 146;

    public final static int FRAME_duck02 = 147;

    public final static int FRAME_duck03 = 148;

    public final static int FRAME_duck04 = 149;

    public final static int FRAME_duck05 = 150;

    public final static int FRAME_duck06 = 151;

    public final static int FRAME_duck07 = 152;

    public final static int FRAME_duck08 = 153;

    public final static int FRAME_defens01 = 154;

    public final static int FRAME_defens02 = 155;

    public final static int FRAME_defens03 = 156;

    public final static int FRAME_defens04 = 157;

    public final static int FRAME_defens05 = 158;

    public final static int FRAME_defens06 = 159;

    public final static int FRAME_defens07 = 160;

    public final static int FRAME_defens08 = 161;

    public final static int FRAME_stand01 = 162;

    public final static int FRAME_stand02 = 163;

    public final static int FRAME_stand03 = 164;

    public final static int FRAME_stand04 = 165;

    public final static int FRAME_stand05 = 166;

    public final static int FRAME_stand06 = 167;

    public final static int FRAME_stand07 = 168;

    public final static int FRAME_stand08 = 169;

    public final static int FRAME_stand09 = 170;

    public final static int FRAME_stand10 = 171;

    public final static int FRAME_stand11 = 172;

    public final static int FRAME_stand12 = 173;

    public final static int FRAME_stand13 = 174;

    public final static int FRAME_stand14 = 175;

    public final static int FRAME_stand15 = 176;

    public final static int FRAME_stand16 = 177;

    public final static int FRAME_stand17 = 178;

    public final static int FRAME_stand18 = 179;

    public final static int FRAME_stand19 = 180;

    public final static int FRAME_stand20 = 181;

    public final static int FRAME_stand21 = 182;

    public final static int FRAME_stand22 = 183;

    public final static int FRAME_stand23 = 184;

    public final static int FRAME_stand24 = 185;

    public final static int FRAME_stand25 = 186;

    public final static int FRAME_stand26 = 187;

    public final static int FRAME_stand27 = 188;

    public final static int FRAME_stand28 = 189;

    public final static int FRAME_stand29 = 190;

    public final static int FRAME_stand30 = 191;

    public final static int FRAME_stand31 = 192;

    public final static int FRAME_stand32 = 193;

    public final static int FRAME_stand33 = 194;

    public final static int FRAME_stand34 = 195;

    public final static int FRAME_stand35 = 196;

    public final static int FRAME_stand36 = 197;

    public final static int FRAME_stand37 = 198;

    public final static int FRAME_stand38 = 199;

    public final static int FRAME_stand39 = 200;

    public final static int FRAME_stand40 = 201;

    public final static int FRAME_stand41 = 202;

    public final static int FRAME_stand42 = 203;

    public final static int FRAME_stand43 = 204;

    public final static int FRAME_stand44 = 205;

    public final static int FRAME_stand45 = 206;

    public final static int FRAME_stand46 = 207;

    public final static int FRAME_stand47 = 208;

    public final static int FRAME_stand48 = 209;

    public final static int FRAME_stand49 = 210;

    public final static int FRAME_stand50 = 211;

    public final static int FRAME_stand51 = 212;

    public final static int FRAME_stand52 = 213;

    public final static int FRAME_stand53 = 214;

    public final static int FRAME_stand54 = 215;

    public final static int FRAME_stand55 = 216;

    public final static int FRAME_stand56 = 217;

    public final static int FRAME_stand57 = 218;

    public final static int FRAME_stand58 = 219;

    public final static int FRAME_stand59 = 220;

    public final static int FRAME_stand60 = 221;

    public final static float MODEL_SCALE = 1.000000f;

    static int sound_chest_open;

    static int sound_tentacles_extend;

    static int sound_tentacles_retract;

    static int sound_death;

    static int sound_idle1;

    static int sound_idle2;

    static int sound_idle3;

    static int sound_pain1;

    static int sound_pain2;

    static int sound_sight;

    static int sound_search;

    static int sound_melee1;

    static int sound_melee2;

    static int sound_melee3;

    static EntInteractAdapter brain_sight = new EntInteractAdapter() {
    	public String getID() { return "brain_sight"; }
        public boolean interact(Entity self, Entity other) {
            ServerGame.PF_StartSound(self, Constants.CHAN_VOICE, sound_sight, (float) 1, (float) Constants.ATTN_NORM,
            (float) 0);
            return true;
        }
    };

    static EntityThinkAdapter brain_search = new EntityThinkAdapter() {
    	public String getID() { return "brain_search"; }
        public boolean think(Entity self) {
            ServerGame.PF_StartSound(self, Constants.CHAN_VOICE, sound_search, (float) 1, (float) Constants.ATTN_NORM,
            (float) 0);
            return true;
        }
    };

    //
    //	   STAND
    //

    static Frame brain_frames_stand[] = new Frame[] {
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null) };

    static MonsterMove brain_move_stand = new MonsterMove(FRAME_stand01, FRAME_stand30,
            brain_frames_stand, null);

    static EntityThinkAdapter brain_stand = new EntityThinkAdapter() {
    	public String getID() { return "brain_stand"; }
        public boolean think(Entity self) {
            self.monsterinfo.currentmove = brain_move_stand;
            return true;
        }
    };

    //
    //	   IDLE
    //

    static Frame brain_frames_idle[] = new Frame[] {
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null),
            new Frame(GameAI.ai_stand, 0, null) };

    static MonsterMove brain_move_idle = new MonsterMove(FRAME_stand31, FRAME_stand60,
            brain_frames_idle, brain_stand);

    static EntityThinkAdapter brain_idle = new EntityThinkAdapter() {
    	public String getID() { return "brain_idle"; }
        public boolean think(Entity self) {
            ServerGame.PF_StartSound(self, Constants.CHAN_AUTO, sound_idle3, (float) 1, (float) Constants.ATTN_IDLE,
            (float) 0);
            self.monsterinfo.currentmove = brain_move_idle;
            return true;
        }
    };

    //
    //	   WALK
    //
    static Frame brain_frames_walk1[] = new Frame[] {
            new Frame(GameAI.ai_walk, 7, null),
            new Frame(GameAI.ai_walk, 2, null),
            new Frame(GameAI.ai_walk, 3, null),
            new Frame(GameAI.ai_walk, 3, null),
            new Frame(GameAI.ai_walk, 1, null),
            new Frame(GameAI.ai_walk, 0, null),
            new Frame(GameAI.ai_walk, 0, null),
            new Frame(GameAI.ai_walk, 9, null),
            new Frame(GameAI.ai_walk, -4, null),
            new Frame(GameAI.ai_walk, -1, null),
            new Frame(GameAI.ai_walk, 2, null) };

    static MonsterMove brain_move_walk1 = new MonsterMove(FRAME_walk101, FRAME_walk111,
            brain_frames_walk1, null);

    //	   walk2 is FUBAR, do not use
    /*
     * # if 0 void brain_walk2_cycle(edict_t self) { if (random() > 0.1)
     * self.monsterinfo.nextframe= FRAME_walk220; }
     * 
     * static mframe_t brain_frames_walk2[]= new mframe_t[] { new
     * mframe_t(ai_walk, 3, null), new mframe_t(ai_walk, -2, null), new
     * mframe_t(ai_walk, -4, null), new mframe_t(ai_walk, -3, null), new
     * mframe_t(ai_walk, 0, null), new mframe_t(ai_walk, 1, null), new
     * mframe_t(ai_walk, 12, null), new mframe_t(ai_walk, 0, null), new
     * mframe_t(ai_walk, -3, null), new mframe_t(ai_walk, 0, null), new
     * mframe_t(ai_walk, -2, null), new mframe_t(ai_walk, 0, null), new
     * mframe_t(ai_walk, 0, null), new mframe_t(ai_walk, 1, null), new
     * mframe_t(ai_walk, 0, null), new mframe_t(ai_walk, 0, null), new
     * mframe_t(ai_walk, 0, null), new mframe_t(ai_walk, 0, null), new
     * mframe_t(ai_walk, 0, null), new mframe_t(ai_walk, 10, null, // Cycle
     * Start)
     * 
     * new mframe_t(ai_walk, -1, null), new mframe_t(ai_walk, 7, null), new
     * mframe_t(ai_walk, 0, null), new mframe_t(ai_walk, 3, null), new
     * mframe_t(ai_walk, -3, null), new mframe_t(ai_walk, 2, null), new
     * mframe_t(ai_walk, 4, null), new mframe_t(ai_walk, -3, null), new
     * mframe_t(ai_walk, 2, null), new mframe_t(ai_walk, 0, null), new
     * mframe_t(ai_walk, 4, brain_walk2_cycle), new mframe_t(ai_walk, -1, null),
     * new mframe_t(ai_walk, -1, null), new mframe_t(ai_walk, -8, null,) new
     * mframe_t(ai_walk, 0, null), new mframe_t(ai_walk, 1, null), new
     * mframe_t(ai_walk, 5, null), new mframe_t(ai_walk, 2, null), new
     * mframe_t(ai_walk, -1, null), new mframe_t(ai_walk, -5, null)}; static
     * mmove_t brain_move_walk2= new mmove_t(FRAME_walk201, FRAME_walk240,
     * brain_frames_walk2, null);
     *  # endif
     */
    static EntityThinkAdapter brain_walk = new EntityThinkAdapter() {
    	public String getID() { return "brain_walk"; }
        public boolean think(Entity self) {
            //			if (random() <= 0.5)
            self.monsterinfo.currentmove = brain_move_walk1;
            //		else
            //			self.monsterinfo.currentmove = &brain_move_walk2;
            return true;
        }
    };

    //
    //	   DUCK
    //

    static EntityThinkAdapter brain_duck_down = new EntityThinkAdapter() {
    	public String getID() { return "brain_duck_down"; }
        public boolean think(Entity self) {

            if ((self.monsterinfo.aiflags & Constants.AI_DUCKED) != 0)
                return true;
            self.monsterinfo.aiflags |= Constants.AI_DUCKED;
            self.maxs[2] -= 32;
            self.takedamage = Constants.DAMAGE_YES;
            World.SV_LinkEdict(self);
            return true;
        }
    };

    static EntityThinkAdapter brain_duck_hold = new EntityThinkAdapter() {
    	public String getID() { return "brain_duck_hold"; }
        public boolean think(Entity self) {
            if (GameBase.level.time >= self.monsterinfo.pausetime)
                self.monsterinfo.aiflags &= ~Constants.AI_HOLD_FRAME;
            else
                self.monsterinfo.aiflags |= Constants.AI_HOLD_FRAME;
            return true;
        }
    };

    static EntityThinkAdapter brain_duck_up = new EntityThinkAdapter() {
    	public String getID() { return "brain_duck_up"; }
        public boolean think(Entity self) {
            self.monsterinfo.aiflags &= ~Constants.AI_DUCKED;
            self.maxs[2] += 32;
            self.takedamage = Constants.DAMAGE_AIM;
            World.SV_LinkEdict(self);
            return true;
        }
    };

    static EntityDodgeAdapter brain_dodge = new EntityDodgeAdapter() {
    	public String getID() { return "brain_dodge"; }
        public void dodge(Entity self, Entity attacker, float eta) {
            if (Lib.random() > 0.25)
                return;

            if (self.enemy == null)
                self.enemy = attacker;

            self.monsterinfo.pausetime = GameBase.level.time + eta + 0.5f;
            self.monsterinfo.currentmove = brain_move_duck;
            return;
        }
    };

    static Frame brain_frames_death2[] = new Frame[] {
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 9, null),
            new Frame(GameAI.ai_move, 0, null) };

    static EntityThinkAdapter brain_dead = new EntityThinkAdapter() {
    	public String getID() { return "brain_dead"; }
        public boolean think(Entity self) {
            Math3D.VectorSet(self.mins, -16, -16, -24);
            Math3D.VectorSet(self.maxs, 16, 16, -8);
            self.movetype = Constants.MOVETYPE_TOSS;
            self.svflags |= Constants.SVF_DEADMONSTER;
            self.nextthink = 0;
            World.SV_LinkEdict(self);
            return true;
        }
    };

    static MonsterMove brain_move_death2 = new MonsterMove(FRAME_death201,
            FRAME_death205, brain_frames_death2, brain_dead);

    static Frame brain_frames_death1[] = new Frame[] {
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, -2, null),
            new Frame(GameAI.ai_move, 9, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null) };

    static MonsterMove brain_move_death1 = new MonsterMove(FRAME_death101,
            FRAME_death118, brain_frames_death1, brain_dead);

    //
    //	   MELEE
    //

    static EntityThinkAdapter brain_swing_right = new EntityThinkAdapter() {
    	public String getID() { return "brain_swing_right"; }
        public boolean think(Entity self) {
            ServerGame.PF_StartSound(self, Constants.CHAN_BODY, sound_melee1, (float) 1, (float) Constants.ATTN_NORM,
            (float) 0);
            return true;
        }
    };

    static EntityThinkAdapter brain_hit_right = new EntityThinkAdapter() {
    	public String getID() { return "brain_hit_right"; }
        public boolean think(Entity self) {
            float[] aim = { 0, 0, 0 };

            Math3D.VectorSet(aim, Constants.MELEE_DISTANCE, self.maxs[0], 8);
            if (GameWeapon.fire_hit(self, aim, (15 + (Lib.rand() % 5)), 40))
              ServerGame.PF_StartSound(self, Constants.CHAN_WEAPON, sound_melee3, (float) 1, (float) Constants.ATTN_NORM,
              (float) 0);
            return true;
        }
    };

    static EntityThinkAdapter brain_swing_left = new EntityThinkAdapter() {
    	public String getID() { return "brain_swing_left"; }
        public boolean think(Entity self) {
            ServerGame.PF_StartSound(self, Constants.CHAN_BODY, sound_melee2, (float) 1, (float) Constants.ATTN_NORM,
            (float) 0);

            return true;
        }
    };

    static EntityThinkAdapter brain_hit_left = new EntityThinkAdapter() {
    	public String getID() { return "brain_hit_left"; }
        public boolean think(Entity self) {
            float[] aim = { 0, 0, 0 };

            Math3D.VectorSet(aim, Constants.MELEE_DISTANCE, self.mins[0], 8);
            if (GameWeapon.fire_hit(self, aim, (15 + (Lib.rand() % 5)), 40))
              ServerGame.PF_StartSound(self, Constants.CHAN_WEAPON, sound_melee3, (float) 1, (float) Constants.ATTN_NORM,
              (float) 0);

            return true;
        }
    };

    static EntityThinkAdapter brain_chest_open = new EntityThinkAdapter() {
    	public String getID() { return "brain_chest_open"; }
        public boolean think(Entity self) {
            self.spawnflags &= ~65536;
            self.monsterinfo.power_armor_type = Constants.POWER_ARMOR_NONE;
            ServerGame.PF_StartSound(self, Constants.CHAN_BODY, sound_chest_open, (float) 1, (float) Constants.ATTN_NORM,
            (float) 0);
            return true;
        }
    };

    static EntityThinkAdapter brain_tentacle_attack = new EntityThinkAdapter() {
    	public String getID() { return "brain_tentacle_attack"; }
        public boolean think(Entity self) {

            float[] aim = { 0, 0, 0 };

            Math3D.VectorSet(aim, Constants.MELEE_DISTANCE, 0, 8);
            if (GameWeapon.fire_hit(self, aim, (10 + (Lib.rand() % 5)), -600)
                    && GameBase.skill.value > 0)
                self.spawnflags |= 65536;
            ServerGame.PF_StartSound(self, Constants.CHAN_WEAPON, sound_tentacles_retract, (float) 1, (float) Constants.ATTN_NORM,
            (float) 0);
            return true;
        }
    };

    static Frame brain_frames_attack1[] = new Frame[] {
            new Frame(GameAI.ai_charge, 8, null),
            new Frame(GameAI.ai_charge, 3, null),
            new Frame(GameAI.ai_charge, 5, null),
            new Frame(GameAI.ai_charge, 0, null),
            new Frame(GameAI.ai_charge, -3, brain_swing_right),
            new Frame(GameAI.ai_charge, 0, null),
            new Frame(GameAI.ai_charge, -5, null),
            new Frame(GameAI.ai_charge, -7, brain_hit_right),
            new Frame(GameAI.ai_charge, 0, null),
            new Frame(GameAI.ai_charge, 6, brain_swing_left),
            new Frame(GameAI.ai_charge, 1, null),
            new Frame(GameAI.ai_charge, 2, brain_hit_left),
            new Frame(GameAI.ai_charge, -3, null),
            new Frame(GameAI.ai_charge, 6, null),
            new Frame(GameAI.ai_charge, -1, null),
            new Frame(GameAI.ai_charge, -3, null),
            new Frame(GameAI.ai_charge, 2, null),
            new Frame(GameAI.ai_charge, -11, null) };

    static EntityThinkAdapter brain_chest_closed = new EntityThinkAdapter() {
    	public String getID() { return "brain_chest_closed"; }
        public boolean think(Entity self) {

            self.monsterinfo.power_armor_type = Constants.POWER_ARMOR_SCREEN;
            if ((self.spawnflags & 65536) != 0) {
                self.spawnflags &= ~65536;
                self.monsterinfo.currentmove = brain_move_attack1;
            }
            return true;
        }
    };

    static Frame brain_frames_attack2[] = new Frame[] {
            new Frame(GameAI.ai_charge, 5, null),
            new Frame(GameAI.ai_charge, -4, null),
            new Frame(GameAI.ai_charge, -4, null),
            new Frame(GameAI.ai_charge, -3, null),
            new Frame(GameAI.ai_charge, 0, brain_chest_open),
            new Frame(GameAI.ai_charge, 0, null),
            new Frame(GameAI.ai_charge, 13, brain_tentacle_attack),
            new Frame(GameAI.ai_charge, 0, null),
            new Frame(GameAI.ai_charge, 2, null),
            new Frame(GameAI.ai_charge, 0, null),
            new Frame(GameAI.ai_charge, -9, brain_chest_closed),
            new Frame(GameAI.ai_charge, 0, null),
            new Frame(GameAI.ai_charge, 4, null),
            new Frame(GameAI.ai_charge, 3, null),
            new Frame(GameAI.ai_charge, 2, null),
            new Frame(GameAI.ai_charge, -3, null),
            new Frame(GameAI.ai_charge, -6, null) };

    static EntityThinkAdapter brain_melee = new EntityThinkAdapter() {
    	public String getID() { return "brain_melee"; }
        public boolean think(Entity self) {
            if (Lib.random() <= 0.5)
                self.monsterinfo.currentmove = brain_move_attack1;
            else
                self.monsterinfo.currentmove = brain_move_attack2;

            return true;
        }
    };

    //
    //	   RUN
    //

    static Frame brain_frames_run[] = new Frame[] {
            new Frame(GameAI.ai_run, 9, null),
            new Frame(GameAI.ai_run, 2, null),
            new Frame(GameAI.ai_run, 3, null),
            new Frame(GameAI.ai_run, 3, null),
            new Frame(GameAI.ai_run, 1, null),
            new Frame(GameAI.ai_run, 0, null),
            new Frame(GameAI.ai_run, 0, null),
            new Frame(GameAI.ai_run, 10, null),
            new Frame(GameAI.ai_run, -4, null),
            new Frame(GameAI.ai_run, -1, null),
            new Frame(GameAI.ai_run, 2, null) };

    static MonsterMove brain_move_run = new MonsterMove(FRAME_walk101, FRAME_walk111,
            brain_frames_run, null);

    static EntityThinkAdapter brain_run = new EntityThinkAdapter() {
    	public String getID() { return "brain_run"; }
        public boolean think(Entity self) {
            self.monsterinfo.power_armor_type = Constants.POWER_ARMOR_SCREEN;
            if ((self.monsterinfo.aiflags & Constants.AI_STAND_GROUND) != 0)
                self.monsterinfo.currentmove = brain_move_stand;
            else
                self.monsterinfo.currentmove = brain_move_run;
            return true;
        }
    };

    static Frame brain_frames_defense[] = new Frame[] {
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null) };

    static MonsterMove brain_move_defense = new MonsterMove(FRAME_defens01,
            FRAME_defens08, brain_frames_defense, null);

    static Frame brain_frames_pain3[] = new Frame[] {
            new Frame(GameAI.ai_move, -2, null),
            new Frame(GameAI.ai_move, 2, null),
            new Frame(GameAI.ai_move, 1, null),
            new Frame(GameAI.ai_move, 3, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, -4, null) };

    static MonsterMove brain_move_pain3 = new MonsterMove(FRAME_pain301, FRAME_pain306,
            brain_frames_pain3, brain_run);

    static Frame brain_frames_pain2[] = new Frame[] {
            new Frame(GameAI.ai_move, -2, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 3, null),
            new Frame(GameAI.ai_move, 1, null),
            new Frame(GameAI.ai_move, -2, null) };

    static MonsterMove brain_move_pain2 = new MonsterMove(FRAME_pain201, FRAME_pain208,
            brain_frames_pain2, brain_run);

    static Frame brain_frames_pain1[] = new Frame[] {
            new Frame(GameAI.ai_move, -6, null),
            new Frame(GameAI.ai_move, -2, null),
            new Frame(GameAI.ai_move, -6, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 2, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 2, null),
            new Frame(GameAI.ai_move, 1, null),
            new Frame(GameAI.ai_move, 7, null),
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, 3, null),
            new Frame(GameAI.ai_move, -1, null) };

    static MonsterMove brain_move_pain1 = new MonsterMove(FRAME_pain101, FRAME_pain121,
            brain_frames_pain1, brain_run);

    static Frame brain_frames_duck[] = new Frame[] {
            new Frame(GameAI.ai_move, 0, null),
            new Frame(GameAI.ai_move, -2, brain_duck_down),
            new Frame(GameAI.ai_move, 17, brain_duck_hold),
            new Frame(GameAI.ai_move, -3, null),
            new Frame(GameAI.ai_move, -1, brain_duck_up),
            new Frame(GameAI.ai_move, -5, null),
            new Frame(GameAI.ai_move, -6, null),
            new Frame(GameAI.ai_move, -6, null) };

    static MonsterMove brain_move_duck = new MonsterMove(FRAME_duck01, FRAME_duck08,
            brain_frames_duck, brain_run);

    static EntityPainAdapter brain_pain = new EntityPainAdapter() {
    	public String getID() { return "brain_pain"; }
        public void pain(Entity self, Entity other, float kick, int damage) {
            float r;

            if (self.health < (self.max_health / 2))
                self.s.skinnum = 1;

            if (GameBase.level.time < self.pain_debounce_time)
                return;

            self.pain_debounce_time = GameBase.level.time + 3;
            if (GameBase.skill.value == 3)
                return; // no pain anims in nightmare

            r = Lib.random();
            if (r < 0.33) {
                ServerGame.PF_StartSound(self, Constants.CHAN_VOICE, sound_pain1, (float) 1, (float) Constants.ATTN_NORM,
                (float) 0);
                self.monsterinfo.currentmove = brain_move_pain1;
            } else if (r < 0.66) {
                ServerGame.PF_StartSound(self, Constants.CHAN_VOICE, sound_pain2, (float) 1, (float) Constants.ATTN_NORM,
                (float) 0);
                self.monsterinfo.currentmove = brain_move_pain2;
            } else {
                ServerGame.PF_StartSound(self, Constants.CHAN_VOICE, sound_pain1, (float) 1, (float) Constants.ATTN_NORM,
                (float) 0);
                self.monsterinfo.currentmove = brain_move_pain3;
            }
        }

    };

    static EntityDieAdapter brain_die = new EntityDieAdapter() {
    	public String getID() { return "brain_die"; }
        public void die(Entity self, Entity inflictor, Entity attacker,
                int damage, float[] point) {
            int n;

            self.s.effects = 0;
            self.monsterinfo.power_armor_type = Constants.POWER_ARMOR_NONE;

            //	   check for gib
            if (self.health <= self.gib_health) {
                ServerGame.PF_StartSound(self, Constants.CHAN_VOICE, ServerInit.SV_SoundIndex("misc/udeath.wav"), (float) 1, (float) Constants.ATTN_NORM,
                (float) 0);
                for (n = 0; n < 2; n++)
                    GameMisc.ThrowGib(self, "models/objects/gibs/bone/tris.md2",
                            damage, Constants.GIB_ORGANIC);
                for (n = 0; n < 4; n++)
                    GameMisc.ThrowGib(self,
                            "models/objects/gibs/sm_meat/tris.md2", damage,
                            Constants.GIB_ORGANIC);
                GameMisc.ThrowHead(self, "models/objects/gibs/head2/tris.md2",
                        damage, Constants.GIB_ORGANIC);
                self.deadflag = Constants.DEAD_DEAD;
                return;
            }

            if (self.deadflag == Constants.DEAD_DEAD)
                return;

            //	   regular death
            ServerGame.PF_StartSound(self, Constants.CHAN_VOICE, sound_death, (float) 1, (float) Constants.ATTN_NORM,
            (float) 0);
            self.deadflag = Constants.DEAD_DEAD;
            self.takedamage = Constants.DAMAGE_YES;
            if (Lib.random() <= 0.5)
                self.monsterinfo.currentmove = brain_move_death1;
            else
                self.monsterinfo.currentmove = brain_move_death2;
        }
    };

    static MonsterMove brain_move_attack1 = new MonsterMove(FRAME_attak101,
            FRAME_attak118, brain_frames_attack1, brain_run);

    static MonsterMove brain_move_attack2 = new MonsterMove(FRAME_attak201,
            FRAME_attak217, brain_frames_attack2, brain_run);

    /*
     * QUAKED monster_brain (1 .5 0) (-16 -16 -24) (16 16 32) Ambush
     * Trigger_Spawn Sight
     */
    public static void SP_monster_brain(Entity self) {
        if (GameBase.deathmatch.value != 0) {
            GameUtil.G_FreeEdict(self);
            return;
        }

        sound_chest_open = ServerInit.SV_SoundIndex("brain/brnatck1.wav");
        sound_tentacles_extend = ServerInit.SV_SoundIndex("brain/brnatck2.wav");
        sound_tentacles_retract = ServerInit.SV_SoundIndex("brain/brnatck3.wav");
        sound_death = ServerInit.SV_SoundIndex("brain/brndeth1.wav");
        sound_idle1 = ServerInit.SV_SoundIndex("brain/brnidle1.wav");
        sound_idle2 = ServerInit.SV_SoundIndex("brain/brnidle2.wav");
        sound_idle3 = ServerInit.SV_SoundIndex("brain/brnlens1.wav");
        sound_pain1 = ServerInit.SV_SoundIndex("brain/brnpain1.wav");
        sound_pain2 = ServerInit.SV_SoundIndex("brain/brnpain2.wav");
        sound_sight = ServerInit.SV_SoundIndex("brain/brnsght1.wav");
        sound_search = ServerInit.SV_SoundIndex("brain/brnsrch1.wav");
        sound_melee1 = ServerInit.SV_SoundIndex("brain/melee1.wav");
        sound_melee2 = ServerInit.SV_SoundIndex("brain/melee2.wav");
        sound_melee3 = ServerInit.SV_SoundIndex("brain/melee3.wav");

        self.movetype = Constants.MOVETYPE_STEP;
        self.solid = Constants.SOLID_BBOX;
        self.s.modelindex = ServerInit.SV_ModelIndex("models/monsters/brain/tris.md2");
        Math3D.VectorSet(self.mins, -16, -16, -24);
        Math3D.VectorSet(self.maxs, 16, 16, 32);

        self.health = 300;
        self.gib_health = -150;
        self.mass = 400;

        self.pain = brain_pain;
        self.die = brain_die;

        self.monsterinfo.stand = brain_stand;
        self.monsterinfo.walk = brain_walk;
        self.monsterinfo.run = brain_run;
        self.monsterinfo.dodge = brain_dodge;
        //		self.monsterinfo.attack = brain_attack;
        self.monsterinfo.melee = brain_melee;
        self.monsterinfo.sight = brain_sight;
        self.monsterinfo.search = brain_search;
        self.monsterinfo.idle = brain_idle;

        self.monsterinfo.power_armor_type = Constants.POWER_ARMOR_SCREEN;
        self.monsterinfo.power_armor_power = 100;

        World.SV_LinkEdict(self);

        self.monsterinfo.currentmove = brain_move_stand;
        self.monsterinfo.scale = MODEL_SCALE;

        GameAI.walkmonster_start.think(self);
    }
}
